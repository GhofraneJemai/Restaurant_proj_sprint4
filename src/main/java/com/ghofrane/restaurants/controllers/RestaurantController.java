package com.ghofrane.restaurants.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.service.RestaurantService;

import jakarta.validation.Valid;

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
    public String showCreate(ModelMap modelMap)
    {
        List<Type> types = restaurantService.getAllTypes();  // Assurez-vous d'avoir une méthode getAllTypes dans votre service
        modelMap.addAttribute("restaurant", new Restaurant());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("types", types);
        return "formRestaurant";
    }

    @RequestMapping("/saveRestaurant")
    public String saveRestaurant(@Valid Restaurant restaurant, 
                                 BindingResult bindingResult,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "2") int size,
                                 ModelMap modelMap) {
        int currentPage;
        boolean isNew = false;

        // Si le formulaire contient des erreurs, retourner à la page de formulaire
        if (bindingResult.hasErrors()) {
            List<Type> types = restaurantService.getAllTypes(); // Ajouté ici
            modelMap.addAttribute("types", types);              // Ajouté ici
            modelMap.addAttribute("mode", "new");               // Important pour afficher le bon titre
            return "formRestaurant";
        }


        // Vérification s'il s'agit d'un ajout ou d'une modification
        if (restaurant.getIdRestaurant() == null) {
            isNew = true;  // C'est un ajout
        }

        // Sauvegarder le restaurant (ajout ou modification)
        restaurantService.saveRestaurant(restaurant);

        // Logique de redirection après l'ajout ou la modification
        if (isNew) {
            // Si c'est un ajout, on va à la dernière page de la liste
            Page<Restaurant> restaurants = restaurantService.getAllRestaurantsParPage(page, size);
            currentPage = restaurants.getTotalPages() - 1;  // Dernière page
        } else {
            // Si c'est une modification, on reste sur la page actuelle
            currentPage = page;
        }

        // Rediriger vers la liste des restaurants avec la page et la taille appropriées
        return "redirect:/ListeRestaurants?page=" + currentPage + "&size=" + size;
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
    @RequestMapping("/modifierRestaurant")
    public String editerRestaurant(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size) {
        Restaurant r = restaurantService.getRestaurant(id);
        List<Type> types = restaurantService.getAllTypes();

        modelMap.addAttribute("restaurant", r);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("types", types);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        return "formRestaurant";
    }


    @RequestMapping("/updateRestaurant")
    public String updateRestaurant(@Valid Restaurant restaurant,
                                   BindingResult bindingResult,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;

        // Si le formulaire contient des erreurs, retourner à la page de formulaire
        if (bindingResult.hasErrors()) {
            return "formRestaurant";
        }

        // Sauvegarder les modifications
        restaurantService.saveRestaurant(restaurant);

        // Rester sur la même page après modification
        currentPage = page;

        // Rediriger vers la liste des restaurants avec les bons paramètres
        return "redirect:/ListeRestaurants?page=" + currentPage + "&size=" + size;
    }
    @GetMapping(value = "/")
    public String welcome() {
     return "index";
    }


  


}
