package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.recette.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByOrderByNom();

    @Query(value = "SELECT r.ingredients FROM Recette r WHERE r.id = :id")
    Iterable<Ingredient> findIngredientsById(@Param("id") long id);

    @Query(value = "SELECT count(i) FROM Ingredient i")
    int nbrIngredients();
}
