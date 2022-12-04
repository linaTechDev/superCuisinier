package com.lina.supercuisinier.repository;

import com.lina.supercuisinier.models.recette.GardeManger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeMangerRepository extends JpaRepository<GardeManger, Long> {
    /*
    SELECT DISTINCT r.* FROM public.recette r
join public.recette_ingredients ON recette_ingredients.recette_id = r.id
join public.ingredient i ON i.id = recette_ingredients.ingredients_id
WHERE i.nom IN (SELECT ingredient.nom FROM public.garde_manger_ingredients
				join public.ingredient ON ingredient.id = garde_manger_ingredients.ingredients_id
			   )
ORDER by r.titre*/
    //@Query(value = "SELECT g FROM GardeManger g limit 1")

}
