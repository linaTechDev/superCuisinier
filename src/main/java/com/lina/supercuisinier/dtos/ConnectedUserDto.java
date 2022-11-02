package com.lina.supercuisinier.dtos;

import com.lina.supercuisinier.models.ConnectedUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectedUserDto {
    private String token;
    private String prenom;
    private String nomFamille;
    private String nomUtilisateur;

    public ConnectedUser toConnectedUser() {
        return new ConnectedUser(
                token,
                prenom,
                nomFamille,
                nomUtilisateur
        );
    }
}
