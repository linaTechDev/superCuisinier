package com.lina.supercuisinier.dtos.recette;

import com.lina.supercuisinier.models.recette.Ingredient;
import com.lina.supercuisinier.models.recette.Recette;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecetteDto {
    private String id;
    private String titre;
    private String portion;
    private String calories;
    private List<IngredientDto> ingredientDtos;

    public Recette toRecette() {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient[ingredientDtos.size()]);
        for (int i = 0; i < ingredientDtos.size(); i++) {
            ingredients.set(i, ingredientDtos.get(i).toIngredient());
        }
        final Recette recette = new Recette(
                titre,
                portion,
                calories,
                ingredients
        );
        long oldId;
        try {
            oldId = Integer.parseInt(id);
            if (oldId > 0)
                recette.setId(oldId);
        } catch (NumberFormatException ignored) {}
        return recette;
    }
}
