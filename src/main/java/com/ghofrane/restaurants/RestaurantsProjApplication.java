package com.ghofrane.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.repos.TypeRepository;
import com.ghofrane.restaurants.service.RestaurantService;
import java.util.Date;


@SpringBootApplication
public class RestaurantsProjApplication implements CommandLineRunner {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    RestaurantRepository restaurantRepository;
    
    @Autowired
    private TypeRepository typeRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantsProjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Création et enregistrement d'un type de restaurant
        Type typeCuisineFrancaise = new Type("Cuisine Française", "Spécialités françaises raffinées");
        typeRepository.save(typeCuisineFrancaise);

        // Création et enregistrement de nouveaux restaurants avec un type
        Restaurant restaurant1 = new Restaurant("Le Gourmet", "123 Rue Principale", new Date(), 4.5);
        restaurant1.setType(typeCuisineFrancaise);
        
        Restaurant restaurant2 = new Restaurant("Chez Marie", "456 Rue de Paris", new Date(), 4.7);
        restaurant2.setType(typeCuisineFrancaise);
        
        // Sauvegarde dans la base de données via le repository
        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);
    }
}
