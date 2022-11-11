package com.lina.supercuisinier.controllers;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.dtos.recette.IngredientForm;
import com.lina.supercuisinier.dtos.recette.RecetteDto;
import com.lina.supercuisinier.services.recette.IngredientService;
import com.lina.supercuisinier.services.recette.RecetteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientService ingredientService;
    private RecetteService recetteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public IngredientDto createIngredient(@RequestBody IngredientForm ingredientForm) {
        RecetteDto recetteDto = recetteService.findByTitre(ingredientForm.getTitre());
        IngredientDto ingredientDto = new IngredientDto(
                null,
                ingredientForm.getNom(),
                recetteDto
        );
        return ingredientService.saveIngredient(ingredientDto.toIngredient());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{titre}")
    public List<IngredientDto> getAllIngredients(@PathVariable String titre) {
        RecetteDto recetteDto = recetteService.findByTitre(titre);
        if (recetteDto == null) {
            throw new NullPointerException();
        }
        else {
            return ingredientService.getAllIngredients(recetteDto);
        }
    }

    @PutMapping("/{id}")
    public IngredientDto updateIngredient(@PathVariable long id,
                                          @RequestBody IngredientDto ingredientDto) {
        IngredientDto ingredient = ingredientService.getIngredient(id);

        ingredient.setNom(ingredientDto.getNom());

        return ingredientService.saveIngredient(ingredient.toIngredient());
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable long id) {
        IngredientDto ingredientDto = ingredientService.getIngredient(id);
        ingredientService.deleteIngredient(ingredientDto.toIngredient());
    }
}
