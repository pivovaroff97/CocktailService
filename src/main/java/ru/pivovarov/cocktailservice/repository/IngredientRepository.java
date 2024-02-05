package ru.pivovarov.cocktailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pivovarov.cocktailservice.repository.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
