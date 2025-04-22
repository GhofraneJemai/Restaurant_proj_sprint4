package com.ghofrane.restaurants.service;

import com.ghofrane.restaurants.entities.Role;
import com.ghofrane.restaurants.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
