package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.dtos.recette.GardeMangerDto;
import com.lina.supercuisinier.models.recette.GardeManger;
import com.lina.supercuisinier.repository.GardeMangerRepository;
import com.lina.supercuisinier.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GardeMangerService {

    private GardeMangerRepository gardeMangerRepository;
    private IngredientRepository ingredientRepository;

    public GardeMangerService(GardeMangerRepository gardeMangerRepository, IngredientRepository ingredientRepository) {
        this.gardeMangerRepository = gardeMangerRepository;
        this.ingredientRepository = ingredientRepository;
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

    public void deleteGardeManger(GardeManger gardeManger) {
        gardeMangerRepository.delete(gardeManger);
    }

    public void deleteAllGardeManger() {
        gardeMangerRepository.deleteAll();
    }
}
