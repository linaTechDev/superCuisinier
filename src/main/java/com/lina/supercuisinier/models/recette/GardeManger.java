package com.lina.supercuisinier.models.recette;

import com.lina.supercuisinier.dtos.recette.GardeMangerDto;
import com.lina.supercuisinier.dtos.recette.IngredientDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "gardeManger",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "nom")
})
public class GardeManger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @OneToMany
    List<Ingredient> ingredients;

    public GardeManger(String nom, List<Ingredient> ingredients) {
        this.nom = nom;
        this.ingredients = ingredients;
    }

    public GardeMangerDto toGardeMangerDto() {
        List<IngredientDto> ingredientDtos = Arrays.asList(new IngredientDto[ingredients.size()]);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredientDtos.set(i, ingredients.get(i).toIngredientDto());
        }
        return new GardeMangerDto(
                String.valueOf(id),
                nom,
                ingredientDtos
        );
    }
}
