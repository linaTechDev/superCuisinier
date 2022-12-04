package com.lina.supercuisinier.dtos.recette;

import com.lina.supercuisinier.models.recette.GardeManger;
import com.lina.supercuisinier.models.recette.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GardeMangerDto {
    private String id;
    private String nom;
    private List<IngredientDto> ingredientDtos;

    public GardeManger toGardeManger() {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient[ingredientDtos.size()]);
        for (int i = 0; i < ingredientDtos.size(); i++) {
            ingredients.set(i, ingredientDtos.get(i).toIngredient());
        }
        final GardeManger gardeManger = new GardeManger(
                nom,
                ingredients
        );
        long oldId;
        try {
            oldId = Integer.parseInt(id);
            if (oldId > 0)
                gardeManger.setId(oldId);
        } catch (NumberFormatException ignored) {}
        return gardeManger;
    }
}
