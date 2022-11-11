package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.dtos.recette.RecetteDto;
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

    public IngredientDto saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient).toIngredientDto();
    }

    public IngredientDto getIngredient(long ingredientId) {
        return ingredientRepository.findById(ingredientId).get().toIngredientDto();
    }

    public List<IngredientDto> getAllIngredients(RecetteDto recetteDto) {
        List<Ingredient> ingredients = ingredientRepository.getIngredientRecette(recetteDto.getTitre());
        List<IngredientDto> ingredientDtos = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            ingredientDtos.add(ingredient.toIngredientDto());
        }
        return ingredientDtos;
    }

    public void deleteIngredient(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }
}
