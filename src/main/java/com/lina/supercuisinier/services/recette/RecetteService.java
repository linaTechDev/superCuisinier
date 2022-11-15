package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.dtos.recette.RecetteDto;
import com.lina.supercuisinier.models.recette.Ingredient;
import com.lina.supercuisinier.models.recette.Recette;
import com.lina.supercuisinier.repository.IngredientRepository;
import com.lina.supercuisinier.repository.RecetteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {

    private RecetteRepository recetteRepository;
    private IngredientRepository ingredientRepository;

    public RecetteService(RecetteRepository recetteRepository, IngredientRepository ingredientRepository) {
        this.recetteRepository = recetteRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public RecetteDto saveRecette(Recette recette) {
        return recetteRepository.save(recette).toRecetteDto();
    }

    public RecetteDto getRecette(long recetteId) {
        return recetteRepository.findById(recetteId).get().toRecetteDto();
    }

    public List<RecetteDto> findByTitre(String titre) {
        List<Recette> recettes = recetteRepository.getAllRecetteByTitre(titre);
        List<RecetteDto> recetteDtos = new ArrayList<>();

        for (Recette recette: recettes) {
            recetteDtos.add(recette.toRecetteDto());
        }
        return recetteDtos;
    }

    public List<RecetteDto> getAllRecettes() {
        List<Recette> recettes = recetteRepository.findAll();
        List<RecetteDto> recetteDtos = new ArrayList<>();

        for (Recette recette: recettes) {
            recetteDtos.add(recette.toRecetteDto());
        }
        return recetteDtos;
    }

    public List<IngredientDto> getIngredientsByRecetteId(long id) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findIngredientsById(id);
        List<IngredientDto> ingredientDtos = new ArrayList<>();

        for (Ingredient ingredient: ingredients) {
            ingredientDtos.add(ingredient.toIngredientDto());
        }
        return ingredientDtos;
    }

    public List<RecetteDto> getRecetteByIngredientsId(long id) {
        List<Recette> recettes = recetteRepository.findByIngredientsId(id);
        List<RecetteDto> recetteDtos = new ArrayList<>();

        for (Recette recette: recettes) {
            recetteDtos.add(recette.toRecetteDto());
        }
        return recetteDtos;
    }

    public void deleteRecette(Recette recette) {
        recetteRepository.delete(recette);
    }

    public void deleteAllRecette() {
        recetteRepository.deleteAll();
    }
}
