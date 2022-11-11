package com.lina.supercuisinier.models.recette;

import com.lina.supercuisinier.dtos.recette.IngredientDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String nom;

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public IngredientDto toIngredientDto() {
        return new IngredientDto(
                String.valueOf(id),
                nom
        );
    }
}
