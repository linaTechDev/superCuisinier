package com.lina.supercuisinier.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lina.supercuisinier.dtos.CreatedUserDto;
import com.lina.supercuisinier.dtos.UtilisateurDto;
import com.lina.supercuisinier.services.UtilisateurService;
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
}
