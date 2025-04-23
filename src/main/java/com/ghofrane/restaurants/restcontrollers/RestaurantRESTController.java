package com.ghofrane.restaurants.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ghofrane.restaurants.dto.RestaurantDTO;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.service.RestaurantService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestaurantRESTController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestaurantDTO getRestaurantById(@PathVariable("id") Long id) {
        return restaurantService.getRestaurant(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public RestaurantDTO createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.saveRestaurant(restaurantDTO);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public RestaurantDTO updateRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.updateRestaurant(restaurantDTO);
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