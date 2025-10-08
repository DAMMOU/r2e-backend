package com.r2e.r2e_backend.repository;

import com.r2e.r2e_backend.entity.ERole;
import com.r2e.r2e_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}