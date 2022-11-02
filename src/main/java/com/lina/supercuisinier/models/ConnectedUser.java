package com.lina.supercuisinier.models;

import lombok.Data;

@Data
public class ConnectedUser {
    private String token;
    private String prenom;
    private String nomFamille;
    private String nomUtilisateur;

    public ConnectedUser(String token, String prenom, String nomFamille, String nomUtilisateur) {
        this.token = token;
        this.prenom = prenom;
        this.nomFamille = nomFamille;
        this.nomUtilisateur = nomUtilisateur;
    }
}
