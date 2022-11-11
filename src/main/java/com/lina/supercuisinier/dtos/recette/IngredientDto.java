package com.lina.supercuisinier.dtos.recette;

import com.lina.supercuisinier.models.recette.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private String id;
    private String nom;
    private RecetteDto recetteDto;

    public Ingredient toIngredient() {
        final Ingredient ingredient = new Ingredient(
                nom,
                recetteDto.toRecette()
        );
        long oldId;
        try {
            oldId = Integer.parseInt(id);
            if (oldId > 0)
                ingredient.setId(oldId);
        } catch (NumberFormatException ignored) {}
        return ingredient;
    }
}
