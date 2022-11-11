package com.lina.supercuisinier.controllers;

import com.lina.supercuisinier.dtos.recette.RecetteDto;
import com.lina.supercuisinier.services.recette.RecetteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/recette")
public class RecetteController {
    private RecetteService recetteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RecetteDto createRecette(@RequestBody RecetteDto recetteDto) {
        return recetteService.saveRecette(recetteDto.toRecette());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RecetteDto getRecette(@PathVariable long id) {
        return recetteService.getRecette(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<RecetteDto> getAllRecettes() {
        return recetteService.getAllRecettes();
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
}
