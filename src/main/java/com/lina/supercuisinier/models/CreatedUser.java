package com.lina.supercuisinier.models;

import lombok.Data;

@Data
public class CreatedUser {
    private String prenom;
    private String nomFamille;
    private String nomUtilisateur;

    public CreatedUser(String prenom, String nomFamille, String nomUtilisateur) {
        this.prenom = prenom;
        this.nomFamille = nomFamille;
        this.nomUtilisateur = nomUtilisateur;
    }
}
