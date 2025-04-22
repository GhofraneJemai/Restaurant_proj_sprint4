package com.ghofrane.restaurants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghofrane.restaurants.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
