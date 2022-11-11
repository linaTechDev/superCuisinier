package com.lina.supercuisinier.repository;

        import com.lina.supercuisinier.models.recette.Ingredient;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByOrderByNom();
}
