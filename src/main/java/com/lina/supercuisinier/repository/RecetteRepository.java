package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.recette.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> getAllRecetteByTitre(String titre);
    List<Recette> getIngredientsId(long id);

    @Query(value = "SELECT r.ingredients FROM Recette r")
    List<Recette> findIngredientsById(long id);
}
