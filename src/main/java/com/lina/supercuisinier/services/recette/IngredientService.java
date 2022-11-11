package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.models.recette.Ingredient;
import com.lina.supercuisinier.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDto> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAllByOrderByNom();
        List<IngredientDto> ingredientDtos = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            ingredientDtos.add(ingredient.toIngredientDto());
        }
        return ingredientDtos;
    }
}
