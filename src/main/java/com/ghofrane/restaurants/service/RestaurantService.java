package com.ghofrane.restaurants.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant r);
    Restaurant updateRestaurant(Restaurant r);
    void deleteRestaurant(Restaurant r);
    void deleteRestaurantById(Long id);
    Restaurant getRestaurant(Long id);
    List<Restaurant> getAllRestaurants();
    Page<Restaurant> getAllRestaurantsParPage(int page, int size) ;
    
    List<Restaurant> findByNomRestaurant(String nom);
    // Find restaurants by name containing the specified string
    List<Restaurant> findByNomRestaurantContains(String nom);
    List<Restaurant> findByType(Type type);
    List<Restaurant> findByTypeId(Long id);
    List<Restaurant> findByNomRestaurantAndNote(String nom,Double note);
    
 // Méthode pour récupérer les restaurants triés par nom (ordre croissant)
    List<Restaurant> findByOrderByNomRestaurantAsc();
    
    // Méthode pour trier les restaurants par nom (ordre croissant) et par type (ordre décroissant)
    List<Restaurant> trierRestaurantsNomsTypes();
}
