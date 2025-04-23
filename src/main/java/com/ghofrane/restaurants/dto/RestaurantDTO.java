package com.ghofrane.restaurants.dto;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghofrane.restaurants.entities.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDTO {
    private Long idRestaurant;
    private String nomRestaurant;
    private String adresse;
    @JsonFormat(pattern = "yyyy-MM-dd")  // Format de la date en JSON
    private Date dateOuverture;
    private Double note;
    private Type type;
    private String description;  // Identifiant unique du type
    
}
