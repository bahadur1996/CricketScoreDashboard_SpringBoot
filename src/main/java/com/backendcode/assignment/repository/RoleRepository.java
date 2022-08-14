package com.backendcode.assignment.repository;

import com.backendcode.assignment.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRole(String role);

}
