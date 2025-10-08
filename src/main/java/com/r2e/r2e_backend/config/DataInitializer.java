package com.r2e.r2e_backend.config;

import com.r2e.r2e_backend.entity.ERole;
import com.r2e.r2e_backend.entity.Role;
import com.r2e.r2e_backend.entity.User;
import com.r2e.r2e_backend.repository.RoleRepository;
import com.r2e.r2e_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Début de l'initialisation des données...");

        try {
            // Initialiser les rôles
            initializeRoles();

            // Initialiser un utilisateur admin
            initializeAdminUser();

            // Initialiser un utilisateur user
            initializeTestUser();

            System.out.println("✅ Initialisation des données terminée !");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de l'initialisation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void initializeRoles() {
        // Vérifier et créer le rôle USER
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            Role userRole = new Role();
            userRole.setName(ERole.ROLE_USER);
            roleRepository.save(userRole);
            System.out.println("✅ Rôle ROLE_USER créé");
        } else {
            System.out.println("ℹ️ Rôle ROLE_USER existe déjà");
        }

        // Vérifier et créer le rôle ADMIN
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(ERole.ROLE_ADMIN);
            roleRepository.save(adminRole);
            System.out.println("✅ Rôle ROLE_ADMIN créé");
        } else {
            System.out.println("ℹ️ Rôle ROLE_ADMIN existe déjà");
        }

        // Vérifier et créer le rôle STUDENT
        if (roleRepository.findByName(ERole.ROLE_STUDENT).isEmpty()) {
            Role studentRole = new Role();
            studentRole.setName(ERole.ROLE_STUDENT);
            roleRepository.save(studentRole);
            System.out.println("✅ Rôle ROLE_STUDENT créé");
        } else {
            System.out.println("ℹ️ Rôle ROLE_STUDENT existe déjà");
        }

        // Vérifier et créer le rôle PROFESSOR
        if (roleRepository.findByName(ERole.ROLE_PROFESSOR).isEmpty()) {
            Role professorRole = new Role();
            professorRole.setName(ERole.ROLE_PROFESSOR);
            roleRepository.save(professorRole);
            System.out.println("✅ Rôle ROLE_PROFESSOR créé");
        } else {
            System.out.println("ℹ️ Rôle ROLE_PROFESSOR existe déjà");
        }
    }

    private void initializeAdminUser() {
        // Vérifier si l'admin existe déjà
        if (userRepository.findByEmail("admin@r2e.com").isEmpty()) {
            // Récupérer le rôle ADMIN
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Rôle ADMIN non trouvé"));

            // Créer l'utilisateur admin
            User adminUser = new User();
            adminUser.setFirstName("Admin");
            adminUser.setLastName("System");
            adminUser.setEmail("admin@r2e.com");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setRole(adminRole);
            adminUser.setNewsletter(false);
            adminUser.setTerms(true);

            userRepository.save(adminUser);
            System.out.println("✅ Utilisateur admin créé - Email: admin@r2e.com / Mot de passe: admin123");
        } else {
            System.out.println("ℹ️ Utilisateur admin existe déjà");
        }
    }

    private void initializeTestUser() {
        // Vérifier si l'utilisateur test existe déjà
        if (userRepository.findByEmail("user@r2e.com").isEmpty()) {
            // Récupérer le rôle USER
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Rôle USER non trouvé"));

            // Créer l'utilisateur test
            User testUser = new User();
            testUser.setFirstName("John");
            testUser.setLastName("Doe");
            testUser.setEmail("user@r2e.com");
            testUser.setPassword(passwordEncoder.encode("user123"));
            testUser.setRole(userRole);
            testUser.setStudentType("Bachelor");
            testUser.setNewsletter(true);
            testUser.setTerms(true);

            userRepository.save(testUser);
            System.out.println("✅ Utilisateur test créé - Email: user@r2e.com / Mot de passe: user123");
        } else {
            System.out.println("ℹ️ Utilisateur test existe déjà");
        }
    }
}