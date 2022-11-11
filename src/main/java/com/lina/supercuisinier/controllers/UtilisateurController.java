package com.lina.supercuisinier.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lina.supercuisinier.dtos.utilisateur.ConnectedUserDto;
import com.lina.supercuisinier.dtos.utilisateur.CreatedUserDto;
import com.lina.supercuisinier.dtos.utilisateur.UtilisateurDto;
import com.lina.supercuisinier.services.utilisateur.ConnectedUserService;
import com.lina.supercuisinier.services.utilisateur.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private UtilisateurService utilisateurService;

    @PostMapping("/creation")
    public ResponseEntity<?> createUtilisateur(@Valid @RequestBody UtilisateurDto utilisateurDto) {
        if (utilisateurService.existsByNomUtilisateur(utilisateurDto.getNomUtilisateur())) {
            return ResponseEntity
                    .badRequest()
                    .body("le nom d'utilisateur est déjà pris");
        }

        try {
            utilisateurDto = utilisateurService.saveUtilisateur(utilisateurDto.toUtilisateur());

            CreatedUserDto createdUserDto = new CreatedUserDto(utilisateurDto.getPrenom(), utilisateurDto.getNomFamille(), utilisateurDto.getNomUtilisateur());
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonCreatedUser = ow.writeValueAsString(createdUserDto.toCreatedUser());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(jsonCreatedUser);
        }
        catch(Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping("/connexion")
    public ResponseEntity<?> connexionUtilisateur(@Valid @RequestBody UtilisateurDto utilisateurDto) {
        if (!utilisateurService.existsByNomUtilisateur(utilisateurDto.getNomUtilisateur())) {
            return ResponseEntity
                    .badRequest()
                    .body("le nom d'utlisateur n'existe pas");
        }

        try {
            boolean valide = utilisateurService.validateAuthentification(utilisateurDto.getNomUtilisateur(), utilisateurDto.getMotPasse());
            if (valide) {

                utilisateurDto = utilisateurService.findByNomUtilisateur(utilisateurDto.getNomUtilisateur());

                String token = ConnectedUserService.genereJWT(
                        utilisateurDto.getNomUtilisateur(),
                        utilisateurDto.getPrenom(),
                        utilisateurDto.getNomFamille()
                );

                ConnectedUserDto connectedUserDto = new ConnectedUserDto(token, utilisateurDto.getPrenom(), utilisateurDto.getNomFamille(), utilisateurDto.getNomUtilisateur());
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String jsonConnectedUser = ow.writeValueAsString(connectedUserDto.toConnectedUser());

                return ResponseEntity
                        .accepted()
                        .body(jsonConnectedUser);

            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Mot de passe invalide");
            }
        }
        catch(Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
