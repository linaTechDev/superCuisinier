package com.lina.supercuisinier.models;

import com.lina.supercuisinier.dtos.UtilisateurDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "utilisateur",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "nomUtilisateur")
    })
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String prenom;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nomFamille;

    @NotBlank
    @Size(min = 3, max = 20)
    private String nomUtilisateur;

    @NotBlank
    @Size(min = 6, max = 120)
    private String motPasse;

    public Utilisateur(String prenom, String nomFamille, String nomUtilisateur, String motPasse) {
        this.prenom = prenom;
        this.nomFamille = nomFamille;
        this.nomUtilisateur = nomUtilisateur;
        this.motPasse = motPasse;
    }

    public UtilisateurDto toUtilisateurDto() {
        return new UtilisateurDto(
                String.valueOf(id),
                prenom,
                nomFamille,
                nomUtilisateur,
                motPasse
        );
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "prenom='" + prenom + '\'' +
                ", nomFamille='" + nomFamille + '\'' +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", motPasse='" + motPasse + '\'' +
                '}';
    }
}
