package com.ghofrane.restaurants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.repos.TypeRepository;
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

	
	/*
	@Test
	public void setUp() {
        // Ajouter des types dans la base de données
        Type type1 = new Type();
        type1.setNom("Restaurant Italien");
        typeRepository.save(type1);

        Type type2 = new Type();
        type2.setNom("Restaurant Japonais");
        typeRepository.save(type2);
    }

/*
    @Test
    public void testCreateRestaurant() {
        Restaurant resto = new Restaurant("bistro", "123 Rue Principale", new Date(), 4.5);
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
	/*
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
	 @Test
	    public void testFindByNomRestaurant() {
	        List<Restaurant> restaurants = restaurantRepository.findByNomRestaurant("bistro");
	        assertEquals(1, restaurants.size());
	        assertEquals("bistro", restaurants.get(0).getNomRestaurant());
	    }
	    
	
	    @Test
	    public void testFindByNomRestaurantContains() {
	        List<Restaurant> restaurants = restaurantRepository.findByNomRestaurantContains("b");
	        assertEquals(1, restaurants.size());
	        assertEquals("bistro", restaurants.get(0).getNomRestaurant());
	    }
	@Test
    public void testFindByNomRestaurantAndNote() {
        // Recherche par nom contenant "Test" et note supérieure à 3
        List<Restaurant> results = restaurantRepository.findByNomRestaurantAndNote("b", 3.0);

        // Vérification du nombre de résultats

        // Vérification des valeurs spécifiques
        assertEquals("bistro", results.get(0).getNomRestaurant());
        assertEquals(4.5, results.get(0).getNote());
    }
	@Test
	public void testFindByType() {
	    // Création d'un objet Type avec un ID spécifique
	    Type type1 = new Type();
	    type1.setId(1L);  // Id du type que vous voulez rechercher
	    
	    // Recherche des restaurants par type
	    List<Restaurant> restaurants = restaurantRepository.findByType(type1);
	    
	    // Affichage des résultats pour vérifier
	    for (Restaurant r : restaurants) {
	        System.out.println(r);
	    }
	    
	    // Vous pouvez aussi ajouter des assertions pour vérifier les résultats attendus
	   
	}

	@Test
	public void findByTypeId() {
	    // Recherche des restaurants par ID du type (par exemple, type avec ID = 1)
	    List<Restaurant> restaurants = restaurantRepository.findByTypeId(1L);
	    
	    // Affichage des résultats pour vérifier
	    for (Restaurant r : restaurants) {
	        System.out.println(r);
	    }
	    
	   
	}
	@Test
	public void findByOrderByNomRestaurantAsc() {
	    // Recherche des restaurants triés par nom (ordre croissant)
	    List<Restaurant> restaurants = restaurantRepository.findByOrderByNomRestaurantAsc();
	    
	    // Affichage des résultats pour vérifier
	    for (Restaurant r : restaurants) {
	        System.out.println(r);
	    }
	
	}*/
	@Test
	public void trierRestaurantsNomsTypes() {
	    // Recherche des restaurants triés par nom (ordre croissant) et type (ordre décroissant)
	    List<Restaurant> restaurants = restaurantRepository.trierRestaurantsNomsTypes();
	    
	    // Affichage des résultats pour vérifier
	    for (Restaurant r : restaurants) {
	        System.out.println(r);
	
	}
	}



	    
}
