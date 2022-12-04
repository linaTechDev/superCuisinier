package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.dtos.recette.GardeMangerDto;
import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.dtos.recette.RecetteDto;
import com.lina.supercuisinier.models.recette.GardeManger;
import com.lina.supercuisinier.models.recette.Ingredient;
import com.lina.supercuisinier.repository.GardeMangerRepository;
import com.lina.supercuisinier.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GardeMangerService {

    private GardeMangerRepository gardeMangerRepository;
    private RecetteService recetteService;
    private IngredientRepository ingredientRepository;

    public GardeMangerService(GardeMangerRepository gardeMangerRepository, IngredientRepository ingredientRepository, RecetteService recetteService) {
        this.gardeMangerRepository = gardeMangerRepository;
        this.ingredientRepository = ingredientRepository;
        this.recetteService = recetteService;
    }

    public GardeMangerDto saveGardeManger(GardeManger gardeManger) {
        return gardeMangerRepository.save(gardeManger).toGardeMangerDto();
    }

    public GardeMangerDto getGardeManger(long gardeMangerId) {
        return gardeMangerRepository.findById(gardeMangerId).get().toGardeMangerDto();
    }

    public List<GardeMangerDto> getAllGardeManger() {
        List<GardeManger> gardeMangers = gardeMangerRepository.findAll();
        List<GardeMangerDto> gardeMangerDtos = new ArrayList<>();

        for (GardeManger gardeManger: gardeMangers) {
            gardeMangerDtos.add(gardeManger.toGardeMangerDto());
        }
        return gardeMangerDtos;
    }

    public List<RecetteDto> getRecetteIngredientGardeManger(long id) {
        GardeManger gardeManger = getGardeManger(id).toGardeManger();
        List<RecetteDto> recetteDtos = new ArrayList<>();
        List<Ingredient> ingredientsGardeManger = gardeManger.getIngredients();
        List<RecetteDto> recettes = recetteService.getAllRecettes();
        for (RecetteDto recette : recettes) {
            boolean recetteTrouve = false;
            List<IngredientDto> ingrdients = recette.getIngredientDtos();
            for (IngredientDto ingredient : ingrdients) {
                for (Ingredient ingredientGardeManger : ingredientsGardeManger) {
                    if (ingredientGardeManger.getNom().equals(ingredient.getNom())) {
                        recetteDtos.add(recette);
                        recetteTrouve = true;
                        break;
                    }
                }
                if (recetteTrouve) {
                    break;
                }
            }
        }
        return recetteDtos;
    }

    public void deleteGardeManger(GardeManger gardeManger) {
        gardeMangerRepository.delete(gardeManger);
    }

    public void deleteAllGardeManger() {
        gardeMangerRepository.deleteAll();
    }
}
