package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.recette.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    Recette getRecetteByTitre(String titre);
}
