package com.lina.supercuisinier.services.recette;

import com.lina.supercuisinier.models.recette.Ingredient;
import com.lina.supercuisinier.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BaseDonneesIngredients implements CommandLineRunner {
    private final IngredientRepository ingredientRepository;

    public BaseDonneesIngredients(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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

        saveIngredients(
                lait,
                sucre,
                farine,
                oeuf,
                chocolat,
                banane,
                pomme,
                vanille,
                huile,
                patate,
                oignon,
                poivron,
                fromage,
                tomate,
                pate,
                concombre,
                salade,
                vinaigre,
                sel);
    }

    private void saveIngredients(
            Ingredient lait,
            Ingredient sucre,
            Ingredient farine,
            Ingredient oeuf,
            Ingredient chocolat,
            Ingredient banane,
            Ingredient pomme,
            Ingredient vanille,
            Ingredient huile,
            Ingredient patate,
            Ingredient oignon,
            Ingredient poivron,
            Ingredient fromage,
            Ingredient tomate,
            Ingredient pate,
            Ingredient concombre,
            Ingredient salade,
            Ingredient vinaigre,
            Ingredient sel
    ) {
        Ingredient[] tableau_Ingredients = {
                lait,
                sucre,
                farine,
                oeuf,
                chocolat,
                banane,
                pomme,
                vanille,
                huile,
                patate,
                oignon,
                poivron,
                fromage,
                tomate,
                pate,
                concombre,
                salade,
                vinaigre,
                sel
        };
        ingredientRepository.saveAll(Arrays.asList(tableau_Ingredients));
    }
}
