package com.lina.supercuisinier.controllers;

import com.lina.supercuisinier.dtos.recette.GardeMangerDto;
import com.lina.supercuisinier.services.recette.GardeMangerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gardeManger")
public class GardeMangerController {
    private GardeMangerService gardeMangerService;

    @PostMapping
    public ResponseEntity<GardeMangerDto> createGardeManger(@RequestBody GardeMangerDto gardeMangerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gardeMangerService.saveGardeManger(gardeMangerDto.toGardeManger()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GardeMangerDto> getGardeManger(@PathVariable long id) {
        return ResponseEntity.ok(gardeMangerService.getGardeManger(id));
    }

    @GetMapping
    public ResponseEntity<List<GardeMangerDto>> getAllGardeManger() {
        return ResponseEntity.ok(gardeMangerService.getAllGardeManger());
    }

    @PutMapping("/{id}")
    public GardeMangerDto updateGardeManger(@PathVariable long id,
                                    @RequestBody GardeMangerDto gardeMangerDto) {
        GardeMangerDto gardeManger = gardeMangerService.getGardeManger(id);
        gardeManger.setIngredientDtos(gardeMangerDto.getIngredientDtos());

        return gardeMangerService.saveGardeManger(gardeManger.toGardeManger());
    }

    @DeleteMapping("/{id}")
    public void deleteGardeManger(@PathVariable long id) {
        GardeMangerDto gardeMangerDto = gardeMangerService.getGardeManger(id);
        gardeMangerService.deleteGardeManger(gardeMangerDto.toGardeManger());
    }

    @DeleteMapping
    public void deleteAllRecettes() {
        gardeMangerService.deleteAllGardeManger();
    }
}
