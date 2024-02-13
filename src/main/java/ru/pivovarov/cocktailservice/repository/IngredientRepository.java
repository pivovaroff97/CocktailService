package ru.pivovarov.cocktailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pivovarov.cocktailservice.repository.entity.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByCategory(String category);
    List<Ingredient> findByName(String category);
}
