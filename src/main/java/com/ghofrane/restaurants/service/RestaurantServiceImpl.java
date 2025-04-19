package com.ghofrane.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.repos.TypeRepository;

import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	TypeRepository typeRepository;

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
    @Override
    public List<Restaurant> findByNomRestaurant(String nom) {
        return restaurantRepository.findByNomRestaurant(nom);
    }

    @Override
    public List<Restaurant> findByNomRestaurantContains(String nom) {
        return restaurantRepository.findByNomRestaurantContains(nom);
    }

    @Override
    public List<Restaurant> findByType(Type type) {
        return restaurantRepository.findByType(type);
    }

    @Override
    public List<Restaurant> findByTypeId(Long id) {
        return restaurantRepository.findByTypeId(id);
    }

    @Override
    public List<Restaurant> findByNomRestaurantAndNote(String nom, Double note) {
        return restaurantRepository.findByNomRestaurantAndNote(nom, note);
    }

    @Override
    public List<Restaurant> findByOrderByNomRestaurantAsc() {
        return restaurantRepository.findByOrderByNomRestaurantAsc();
    }

    @Override
    public List<Restaurant> trierRestaurantsNomsTypes() {
        return restaurantRepository.trierRestaurantsNomsTypes();
    }
    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

}
