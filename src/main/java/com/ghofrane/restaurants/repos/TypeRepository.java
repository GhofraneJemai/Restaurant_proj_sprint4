package com.ghofrane.restaurants.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghofrane.restaurants.entities.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
