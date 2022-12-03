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
@Table(name = "gardeManger")
public class GardeManger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    List<Ingredient> ingredients;

    public GardeManger(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public GardeMangerDto toGardeMangerDto() {
        List<IngredientDto> ingredientDtos = Arrays.asList(new IngredientDto[ingredients.size()]);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredientDtos.set(i, ingredients.get(i).toIngredientDto());
        }
        return new GardeMangerDto(
                String.valueOf(id),
                ingredientDtos
        );
    }
}
