package com.ghofrane.restaurants.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ghofrane.restaurants.entities.Type;

import com.ghofrane.restaurants.entities.Restaurant;

@RepositoryRestResource(path = "rest")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	List<Restaurant> findByNomRestaurant(String nom);
    // Find restaurants by name containing the specified string
    List<Restaurant> findByNomRestaurantContains(String nom);
    @Query("select r from Restaurant r where r.nomRestaurant like %:nom% and r.note > :note")
    List<Restaurant> findByNomRestaurantAndNote(
        @Param("nom") String nom,
        @Param("note") Double note);
    @Query("select r from Restaurant r where r.type = ?1")
    List<Restaurant> findByType(Type type);
    List<Restaurant> findByTypeId(Long id);
    List<Restaurant> findByOrderByNomRestaurantAsc();

    @Query("select r from Restaurant r order by r.nomRestaurant ASC, r.type DESC")
    List<Restaurant> trierRestaurantsNomsTypes();
}
