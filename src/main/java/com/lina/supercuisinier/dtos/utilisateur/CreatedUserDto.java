package com.lina.supercuisinier.dtos.utilisateur;

import com.lina.supercuisinier.models.utilisateur.CreatedUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedUserDto {
    private String prenom;
    private String nomFamille;
    private String nomUtilisateur;

    public CreatedUser toCreatedUser() {
        return new CreatedUser(
                prenom,
                nomFamille,
                nomUtilisateur
        );
    }
}
