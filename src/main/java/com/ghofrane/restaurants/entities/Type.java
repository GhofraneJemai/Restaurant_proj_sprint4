package com.ghofrane.restaurants.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identifiant unique du type
    
    private String nom;  // Nom du type (ex: "Cuisine Française")
    
    private String description;  // Description du type (optionnel)

    // Relation One-to-Many : Un type peut avoir plusieurs restaurants
    @JsonIgnore
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
    public Type(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

}
