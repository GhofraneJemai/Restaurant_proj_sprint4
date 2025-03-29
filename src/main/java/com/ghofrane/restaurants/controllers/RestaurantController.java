package com.ghofrane.restaurants.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.service.RestaurantService;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @RequestMapping("/myView")
    public String myView()
    {
    return "myView";
    }

    @RequestMapping("/ListeRestaurants")
    public String listeRestaurants(ModelMap modelMap,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size) {
        System.out.println("Page: " + page + ", Size: " + size);  // Debug output

        Page<Restaurant> restaurants = restaurantService.getAllRestaurantsParPage(page, size);
        
        modelMap.addAttribute("restaurants", restaurants);
        modelMap.addAttribute("pages", new int[restaurants.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);

        return "listeRestaurants";
    }



    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createRestaurant";
    }

    @RequestMapping("/saveRestaurant")
    public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant,
                                 @RequestParam("dateOuverture") String dateOuverture,
                                 @RequestParam("note") Double note,
                                 ModelMap modelMap) throws ParseException {

        // Conversion de la date
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(String.valueOf(dateOuverture));
        restaurant.setDateOuverture(date);
        restaurant.setNote(note);

        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        String msg = "Restaurant enregistré avec Id " + savedRestaurant.getIdRestaurant();
        modelMap.addAttribute("msg", msg);
        return "createRestaurant";
    }

    @RequestMapping("/supprimerRestaurant")
    public String supprimerRestaurant(@RequestParam("id") Long id,
                                      @RequestParam(name = "page", defaultValue = "0") int page,
                                      @RequestParam(name = "size", defaultValue = "2") int size,
                                      ModelMap modelMap) {
        restaurantService.deleteRestaurantById(id);
        Page<Restaurant> restaurants = restaurantService.getAllRestaurantsParPage(page, size);
        modelMap.addAttribute("restaurants", restaurants);
        modelMap.addAttribute("pages", new int[restaurants.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeRestaurants";
    }
  


}
