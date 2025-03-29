package com.ghofrane.restaurants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghofrane.restaurants.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
