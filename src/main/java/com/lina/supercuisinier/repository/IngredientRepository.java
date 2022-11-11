package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.recette.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query(value = "SELECT i FROM Ingredient i WHERE i.recette.titre = :titre")
    List<Ingredient> getIngredientRecette(@Param("titre") String titre);
}
