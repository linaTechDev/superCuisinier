package com.lina.supercuisinier.controllers;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.services.recette.IngredientService;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<IngredientDto> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
}
