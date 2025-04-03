package com.ghofrane.restaurants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.ghofrane.restaurants.entities.Restaurant; 

@SpringBootApplication
public class RestaurantsApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Exposer l'ID pour l'entité Restaurant
        repositoryRestConfiguration.exposeIdsFor(Restaurant.class);
    }
}