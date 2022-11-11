package com.lina.supercuisinier.models.recette;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import com.lina.supercuisinier.dtos.recette.RecetteDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "recette",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "titre")
        })
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titre;

    @NotBlank
    private String portion;

    @NotBlank
    private String calories;

    @ManyToMany
    private List<Ingredient> ingredients;

    public Recette(String titre, String portion, String calories, List<Ingredient> ingredients) {
        this.titre = titre;
        this.portion = portion;
        this.calories = calories;
        this.ingredients = ingredients;
    }

    public RecetteDto toRecetteDto() {
        List<IngredientDto> ingredientDtos = new ArrayList<>(ingredients.size());
        for (int i = 0; i < ingredients.size(); i++) {
            ingredientDtos.set(i, ingredients.get(i).toIngredientDto());
        }
        return new RecetteDto(
                String.valueOf(id),
                titre,
                portion,
                calories,
                ingredientDtos
        );
    }
}
