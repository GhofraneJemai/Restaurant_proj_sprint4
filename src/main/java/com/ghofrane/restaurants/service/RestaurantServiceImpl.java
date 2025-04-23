package com.ghofrane.restaurants.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import com.ghofrane.restaurants.dto.RestaurantDTO;
import com.ghofrane.restaurants.entities.Restaurant;
import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.repos.RestaurantRepository;
import com.ghofrane.restaurants.repos.TypeRepository;

import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	TypeRepository typeRepository;

    @Autowired
    RestaurantRepository restaurantRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public RestaurantDTO saveRestaurant(RestaurantDTO r) {
        return convertEntityToDto(restaurantRepository.save(convertDtoToEntity(r)));
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO r) {
        return convertEntityToDto(restaurantRepository.save(convertDtoToEntity(r)));
    }

    @Override
    public void deleteRestaurant(Restaurant r) {
        restaurantRepository.delete(r);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantDTO getRestaurant(Long id) {
        return convertEntityToDto(restaurantRepository.findById(id).get());
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
 // Nouvelle méthode pour récupérer les restaurants par page
    @Override
    public Page<Restaurant> getAllRestaurantsParPage(int page, int size) {
        // Crée un objet PageRequest avec le numéro de page et la taille de page
        PageRequest pageRequest = PageRequest.of(page, size);
        return restaurantRepository.findAll(pageRequest);
    }
    @Override
    public List<Restaurant> findByNomRestaurant(String nom) {
        return restaurantRepository.findByNomRestaurant(nom);
    }

    @Override
    public List<Restaurant> findByNomRestaurantContains(String nom) {
        return restaurantRepository.findByNomRestaurantContains(nom);
    }

    @Override
    public List<Restaurant> findByType(Type type) {
        return restaurantRepository.findByType(type);
    }

    @Override
    public List<Restaurant> findByTypeId(Long id) {
        return restaurantRepository.findByTypeId(id);
    }

    @Override
    public List<Restaurant> findByNomRestaurantAndNote(String nom, Double note) {
        return restaurantRepository.findByNomRestaurantAndNote(nom, note);
    }

    @Override
    public List<Restaurant> findByOrderByNomRestaurantAsc() {
        return restaurantRepository.findByOrderByNomRestaurantAsc();
    }

    @Override
    public List<Restaurant> trierRestaurantsNomsTypes() {
        return restaurantRepository.trierRestaurantsNomsTypes();
    }
    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
    /*@Override
    public RestaurantDTO convertEntityToDto(Restaurant restaurant) {
    	/*
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setIdRestaurant(restaurant.getIdRestaurant());
        restaurantDTO.setNomRestaurant(restaurant.getNomRestaurant());
        restaurantDTO.setAdresse(restaurant.getAdresse());
        restaurantDTO.setDateOuverture(restaurant.getDateOuverture());
        restaurantDTO.setNote(restaurant.getNote());
        restaurantDTO.setType(restaurant.getType());
        return restaurantDTO;
        

        return RestaurantDTO.builder()
                .idRestaurant(restaurant.getIdRestaurant())
                .nomRestaurant(restaurant.getNomRestaurant())
                .adresse(restaurant.getAdresse())
                .dateOuverture(restaurant.getDateOuverture())
                .note(restaurant.getNote())
                .type(restaurant.getType())
                //.nom(restaurant.getType() != null ? restaurant.getType().getNom() : null)
                .build();
        
    }*/
    @Override
    public RestaurantDTO convertEntityToDto(Restaurant restaurant) {
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }
/*
    @Override
    public Restaurant convertDtoToEntity(RestaurantDTO restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setIdRestaurant(restaurantDto.getIdRestaurant());
        restaurant.setNomRestaurant(restaurantDto.getNomRestaurant());
        restaurant.setAdresse(restaurantDto.getAdresse());
        restaurant.setDateOuverture(restaurantDto.getDateOuverture());
        restaurant.setNote(restaurantDto.getNote());
        restaurant.setType(restaurantDto.getType()); // Assure-toi que le type n'est pas null ou instancié correctement
        return restaurant;
    }*/
    @Override
    public Restaurant convertDtoToEntity(RestaurantDTO restaurantDTO) {
    	Restaurant restaurant = new Restaurant();
    	restaurant = modelMapper.map(restaurantDTO, Restaurant.class);
    	return restaurant;
    }


}
