package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.recette.GardeManger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeMangerRepository extends JpaRepository<GardeManger, Long> {
}
