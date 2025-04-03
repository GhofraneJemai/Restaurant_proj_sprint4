package com.ghofrane.restaurants.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.service.RestaurantService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestaurantRESTController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Restaurant getRestaurantById(@PathVariable("id") Long id) {
        return restaurantService.getRestaurant(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }
    @RequestMapping(value = "/type/{idType}", method = RequestMethod.GET)
    public List<Restaurant> getRestaurantsByTypeId(@PathVariable("idType") Long idType) {
        return restaurantService.findByTypeId(idType);
    }
}