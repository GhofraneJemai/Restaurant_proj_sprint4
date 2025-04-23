package com.ghofrane.restaurants.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.ghofrane.restaurants.dto.RestaurantDTO;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;

public interface RestaurantService {
	RestaurantDTO saveRestaurant(RestaurantDTO r);
	RestaurantDTO getRestaurant(Long id);
    List<RestaurantDTO> getAllRestaurants();
    
    
    
    
    
    RestaurantDTO updateRestaurant(RestaurantDTO r);
    void deleteRestaurant(Restaurant r);
    void deleteRestaurantById(Long id);

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
    
    List<Type> getAllTypes();
    RestaurantDTO convertEntityToDto(Restaurant restaurant);
    Restaurant convertDtoToEntity(RestaurantDTO restaurantDto);



}
