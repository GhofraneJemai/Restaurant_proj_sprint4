package com.ghofrane.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Role;
import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.entities.User;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.repos.TypeRepository;
import com.ghofrane.restaurants.service.RestaurantService;
import com.ghofrane.restaurants.service.UserService;

import jakarta.annotation.PostConstruct;

import java.util.Date;


@SpringBootApplication
public class RestaurantsProjApplication implements CommandLineRunner {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    RestaurantRepository restaurantRepository;
    
    @Autowired
    private TypeRepository typeRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantsProjApplication.class, args);
    }
    /*
   @PostConstruct
	void init_users() {
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));
		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "ghofrane", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));
		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("ghofrane", "USER");
		userService.addRoleToUser("ghofrane", "AGENT");
		userService.addRoleToUser("user1", "USER");
	}*/

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("Password Encoded BCRYPT :******************** ");
    	System.out.println(passwordEncoder.encode("123"));

    	/*
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
        restaurantRepository.save(restaurant2);*/
    }
}
