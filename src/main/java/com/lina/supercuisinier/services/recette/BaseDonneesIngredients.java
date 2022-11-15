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
            Ingredient lait = new Ingredient("lait");
            Ingredient sucre = new Ingredient("sucre");
            Ingredient farine = new Ingredient("farine");
            Ingredient oeuf = new Ingredient("oeuf");
            Ingredient chocolat = new Ingredient("chocolat");
            Ingredient banane = new Ingredient("banane");
            Ingredient pomme = new Ingredient("pomme");
            Ingredient vanille = new Ingredient("vanille");
            Ingredient huile = new Ingredient("huile");
            Ingredient patate = new Ingredient("patate");
            Ingredient oignon = new Ingredient("oignon");
            Ingredient poivron = new Ingredient("poivron");
            Ingredient fromage = new Ingredient("fromage");
            Ingredient tomate = new Ingredient("tomate");
            Ingredient pate = new Ingredient("pâte");
            Ingredient concombre = new Ingredient("concombre");
            Ingredient salade = new Ingredient("salade");
            Ingredient vinaigre = new Ingredient("vinaigre");
            Ingredient sel = new Ingredient("sel");

            ingredientRepository.save(lait);
            ingredientRepository.save(sucre);
            ingredientRepository.save(farine);
            ingredientRepository.save(oeuf);
            ingredientRepository.save(chocolat);
            ingredientRepository.save(banane);
            ingredientRepository.save(pomme);
            ingredientRepository.save(vanille);
            ingredientRepository.save(huile);
            ingredientRepository.save(patate);
            ingredientRepository.save(oignon);
            ingredientRepository.save(poivron);
            ingredientRepository.save(fromage);
            ingredientRepository.save(tomate);
            ingredientRepository.save(pate);
            ingredientRepository.save(concombre);
            ingredientRepository.save(salade);
            ingredientRepository.save(vinaigre);
            ingredientRepository.save(sel);
        }
    }
}
