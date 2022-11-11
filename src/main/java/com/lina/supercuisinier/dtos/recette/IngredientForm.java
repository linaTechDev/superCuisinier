package com.lina.supercuisinier.dtos.recette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientForm {
    private String id;
    private String nom;
    private String titre;
}
