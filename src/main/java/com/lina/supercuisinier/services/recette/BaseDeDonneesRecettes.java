package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.models.recette.Recette;
import com.lina.supercuisinier.repository.IngredientRepository;
import com.lina.supercuisinier.repository.RecetteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BaseDeDonneesRecettes implements CommandLineRunner {
    private final RecetteRepository recetteRepository;
    private final IngredientRepository ingredientRepository;

    public BaseDeDonneesRecettes(RecetteRepository recetteRepository, IngredientRepository ingredientRepository) {
        this.recetteRepository = recetteRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (recetteRepository.nbrRecettes() == 0) {
            recetteRepository.save(
                    new Recette(
                            "Tarte aux bleuets",
                            "8",
                            "280",
                            Arrays.asList(
                                    ingredientRepository.findRecetteIngredientById("farine"),
                                    ingredientRepository.findRecetteIngredientById("sucre"),
                                    ingredientRepository.findRecetteIngredientById("beurre"),
                                    ingredientRepository.findRecetteIngredientById("amande"),
                                    ingredientRepository.findRecetteIngredientById("eau"),
                                    ingredientRepository.findRecetteIngredientById("lait"),
                                    ingredientRepository.findRecetteIngredientById("sel"),
                                    ingredientRepository.findRecetteIngredientById("bleuet"),
                                    ingredientRepository.findRecetteIngredientById("citron")
                            )
                    )
            );
            recetteRepository.save(
                    new Recette(
                            "Pizza fromage",
                            "8",
                            "266",
                            Arrays.asList(
                                    ingredientRepository.findRecetteIngredientById("farine"),
                                    ingredientRepository.findRecetteIngredientById("huile"),
                                    ingredientRepository.findRecetteIngredientById("sucre"),
                                    ingredientRepository.findRecetteIngredientById("levure"),
                                    ingredientRepository.findRecetteIngredientById("sel"),
                                    ingredientRepository.findRecetteIngredientById("eau"),
                                    ingredientRepository.findRecetteIngredientById("sauce tomate"),
                                    ingredientRepository.findRecetteIngredientById("fromage")
                            )
                    )
            );
            recetteRepository.save(
                    new Recette(
                            "Gâteau au chocolat",
                            "10",
                            "371",
                            Arrays.asList(
                                    ingredientRepository.findRecetteIngredientById("chocolat"),
                                    ingredientRepository.findRecetteIngredientById("farine"),
                                    ingredientRepository.findRecetteIngredientById("sucre"),
                                    ingredientRepository.findRecetteIngredientById("beurre"),
                                    ingredientRepository.findRecetteIngredientById("levure"),
                                    ingredientRepository.findRecetteIngredientById("lait"),
                                    ingredientRepository.findRecetteIngredientById("oeuf")
                            )
                    )
            );
            recetteRepository.save(
                    new Recette(
                            "frites",
                            "5",
                            "312",
                            Arrays.asList(
                                    ingredientRepository.findRecetteIngredientById("patate"),
                                    ingredientRepository.findRecetteIngredientById("huile"),
                                    ingredientRepository.findRecetteIngredientById("sel")
                            )
                    )
            );
        }
    }
}
