package com.ghofrane.restaurants;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.service.RestaurantService;

@SpringBootTest
class RestaurantsProjApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
    private RestaurantRepository restaurantRepository;
	
	@Autowired
	RestaurantService restaurantService;

    @Test
    public void testCreateRestaurant() {
        Restaurant resto = new Restaurant("Le Gourmet", "123 Rue Principale", new Date(), 4.5);
        restaurantRepository.save(resto);
    }
    /*
    @Test
    public void testFindRestaurant() {
        Restaurant r = restaurantRepository.findById(2L).get();
        System.out.println(r);
    }
   
    @Test
    public void testUpdateRestaurant() {
        Restaurant r = restaurantRepository.findById(2L).get();
        r.setNomRestaurant("Le Gourmet 2");
        r.setNote(4.7);
        restaurantRepository.save(r);
    }
    
    @Test
    public void testDeleteRestaurant() {
        restaurantRepository.deleteById(2L);
    }
    /*
    @Test
    public void testListerTousRestaurants() {
        List<Restaurant> restos = restaurantRepository.findAll();
        for (Restaurant r : restos) {
            System.out.println(r);
        }
    }*/
	@Test
    public void testGetAllRestaurantsParPage() {
        // Appel de la méthode pour récupérer les restaurants de la première page avec une taille de 2 éléments
        Page<Restaurant> restaurants = restaurantService.getAllRestaurantsParPage(0, 2);
        
        // Afficher la taille de la page
        System.out.println("Size of current page: " + restaurants.getSize());
        
        // Afficher le nombre total d'éléments
        System.out.println("Total elements: " + restaurants.getTotalElements());
        
        // Afficher le nombre total de pages
        System.out.println("Total pages: " + restaurants.getTotalPages());
        
        // Afficher chaque restaurant dans la page
        restaurants.getContent().forEach(r -> {
            System.out.println(r.toString());
        });
    }
}
