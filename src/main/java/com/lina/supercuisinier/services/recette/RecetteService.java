package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.dtos.recette.RecetteDto;
import com.lina.supercuisinier.models.recette.Recette;
import com.lina.supercuisinier.repository.RecetteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {

    private RecetteRepository recetteRepository;

    public RecetteService(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    public RecetteDto saveRecette(Recette recette) {
        return recetteRepository.save(recette).toRecetteDto();
    }

    public RecetteDto getRecette(long recetteId) {
        return recetteRepository.findById(recetteId).get().toRecetteDto();
    }

    public RecetteDto findByTitre(String titre) {
        Recette recette = recetteRepository.getRecetteByTitre(titre);
        if (recette != null) {
            return recette.toRecetteDto();
        }
        return null;
    }

    public List<RecetteDto> getAllRecettes() {
        List<Recette> recettes = recetteRepository.findAll();
        List<RecetteDto> recetteDtos = new ArrayList<>();

        for (Recette recette: recettes) {
            recetteDtos.add(recette.toRecetteDto());
        }
        return recetteDtos;
    }

    public void deleteRecette(Recette recette) {
        recetteRepository.delete(recette);
    }
}
