package com.ghofrane.restaurants.service;

import com.ghofrane.restaurants.entities.Type;
import com.ghofrane.restaurants.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    // Méthode pour récupérer tous les types
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    // Méthode pour ajouter un nouveau type
    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    // Méthode pour trouver un type par son nom

}
