package com.r2e.r2e_backend.service.impl;

import com.r2e.r2e_backend.dto.request.RegisterRequest;
import com.r2e.r2e_backend.entity.ERole;
import com.r2e.r2e_backend.entity.Role;
import com.r2e.r2e_backend.entity.User;
import com.r2e.r2e_backend.repository.RoleRepository;
import com.r2e.r2e_backend.repository.UserRepository;
import com.r2e.r2e_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterRequest registerRequest) {
        // Vérifier si l'email existe déjà
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        // Trouver le rôle (par défaut ROLE_USER si non spécifié)
        ERole roleName = ERole.valueOf(registerRequest.getRoleName());
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        // Créer le nouvel utilisateur
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(role);
        user.setStudentType(registerRequest.getStudentType());
        user.setNewsletter(registerRequest.isNewsletter());
        user.setTerms(registerRequest.isTerms());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}