package com.ghofrane.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant saveRestaurant(Restaurant r) {
        return restaurantRepository.save(r);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant r) {
        return restaurantRepository.save(r);
    }

    @Override
    public void deleteRestaurant(Restaurant r) {
        restaurantRepository.delete(r);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
 // Nouvelle méthode pour récupérer les restaurants par page
    @Override
    public Page<Restaurant> getAllRestaurantsParPage(int page, int size) {
        // Crée un objet PageRequest avec le numéro de page et la taille de page
        PageRequest pageRequest = PageRequest.of(page, size);
        return restaurantRepository.findAll(pageRequest);
    }

}
