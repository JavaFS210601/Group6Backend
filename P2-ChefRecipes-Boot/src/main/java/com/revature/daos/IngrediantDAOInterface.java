package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.database.Ingrediants;

public interface IngrediantDAOInterface extends JpaRepository<Ingrediants, Integer> {

}
