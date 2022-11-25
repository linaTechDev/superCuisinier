package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.models.recette.Ingredient;
import com.lina.supercuisinier.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class BaseDonneesIngredients implements CommandLineRunner {
    private final IngredientRepository ingredientRepository;

    public BaseDonneesIngredients(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ingredientRepository.nbrIngredients() == 0) {
            ingredientRepository.save(new Ingredient("lait"));
            ingredientRepository.save(new Ingredient("sucre"));
            ingredientRepository.save(new Ingredient("farine"));
            ingredientRepository.save(new Ingredient("oeuf"));
            ingredientRepository.save(new Ingredient("chocolat"));
            ingredientRepository.save(new Ingredient("banane"));
            ingredientRepository.save(new Ingredient("pomme"));
            ingredientRepository.save(new Ingredient("vanille"));
            ingredientRepository.save(new Ingredient("huile"));
            ingredientRepository.save(new Ingredient("patate"));
            ingredientRepository.save(new Ingredient("oignon"));
            ingredientRepository.save(new Ingredient("poivron"));
            ingredientRepository.save(new Ingredient("fromage"));
            ingredientRepository.save(new Ingredient("tomate"));
            ingredientRepository.save(new Ingredient("pâte"));
            ingredientRepository.save(new Ingredient("concombre"));
            ingredientRepository.save(new Ingredient("salade"));
            ingredientRepository.save(new Ingredient("vinaigre"));
            ingredientRepository.save(new Ingredient("sel"));
            ingredientRepository.save(new Ingredient("pain"));
            ingredientRepository.save(new Ingredient("poivre"));
            ingredientRepository.save(new Ingredient("beurre"));
            ingredientRepository.save(new Ingredient("bleuet"));
            ingredientRepository.save(new Ingredient("sauce tomate"));
            ingredientRepository.save(new Ingredient("eau"));
            ingredientRepository.save(new Ingredient("levure"));
            ingredientRepository.save(new Ingredient("pâte à tarte"));
            ingredientRepository.save(new Ingredient("amande"));
            ingredientRepository.save(new Ingredient("citron"));
        }
    }
}
