package com.ghofrane.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.service.RestaurantService;
import java.util.Date;


@SpringBootApplication
public class RestaurantsProjApplication implements CommandLineRunner {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    RestaurantRepository restaurantRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantsProjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Exemple de création et d'enregistrement de nouveaux restaurants
        Restaurant restaurant1 = new Restaurant("Le Gourmet", "123 Rue Principale", new Date(), 4.5);
        Restaurant restaurant2 = new Restaurant("Chez Marie", "456 Rue de Paris", new Date(), 4.7);
        
        // Sauvegarder dans la base de données via le repository
        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);
    }
}
