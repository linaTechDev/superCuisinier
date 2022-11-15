package com.lina.supercuisinier.controllers;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.dtos.recette.RecetteDto;
import com.lina.supercuisinier.services.recette.RecetteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/recette")
public class RecetteController {
    private RecetteService recetteService;

    @PostMapping
    public ResponseEntity<RecetteDto> createRecette(@RequestBody RecetteDto recetteDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recetteService.saveRecette(recetteDto.toRecette()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetteDto> getRecette(@PathVariable long id) {
        return ResponseEntity.ok(recetteService.getRecette(id));
    }

    @GetMapping
    public ResponseEntity<List<RecetteDto>> getAllRecettes() {
        return ResponseEntity.ok(recetteService.getAllRecettes());
    }

    @GetMapping("/ingredients/recettes/{id}")
    public ResponseEntity<List<IngredientDto>> getIngredientsByRecetteId(@PathVariable long id) {
        return ResponseEntity.ok(recetteService.getIngredientsByRecetteId(id));
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<List<RecetteDto>> getRecettesByIngredientsId(@PathVariable long id) {
        return ResponseEntity.ok(recetteService.getRecetteByIngredientsId(id));
    }

    @PutMapping("/{id}")
    public RecetteDto updateRecette(@PathVariable long id,
                                          @RequestBody RecetteDto recetteDto) {
        RecetteDto recette = recetteService.getRecette(id);

        recette.setTitre(recetteDto.getTitre());
        recette.setPortion(recetteDto.getPortion());
        recette.setCalories(recetteDto.getCalories());

        return recetteService.saveRecette(recette.toRecette());
    }

    @DeleteMapping("/{id}")
    public void deleteRecette(@PathVariable long id) {
        RecetteDto recetteDto = recetteService.getRecette(id);
        recetteService.deleteRecette(recetteDto.toRecette());
    }

    @DeleteMapping
    public void deleteAllRecettes() {
        recetteService.deleteAllRecette();
    }
}
