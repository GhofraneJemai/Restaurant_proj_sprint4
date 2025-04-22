package com.ghofrane.restaurants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghofrane.restaurants.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
