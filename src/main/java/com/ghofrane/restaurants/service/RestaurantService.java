package com.ghofrane.restaurants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ghofrane.restaurants.entities.Restaurant;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant r);
    Restaurant updateRestaurant(Restaurant r);
    void deleteRestaurant(Restaurant r);
    void deleteRestaurantById(Long id);
    Restaurant getRestaurant(Long id);
    List<Restaurant> getAllRestaurants();
    Page<Restaurant> getAllRestaurantsParPage(int page, int size) ;
}
