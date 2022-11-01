package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
    Boolean existsByNomUtilisateur(String nomUtilisateur);
}
