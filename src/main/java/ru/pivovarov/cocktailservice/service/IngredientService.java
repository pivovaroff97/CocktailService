package ru.pivovarov.cocktailservice.service;

import ru.pivovarov.cocktailservice.repository.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getIngredients();
    List<Ingredient> getIngredientsByName(String name);
    List<Ingredient> getIngredientsByCategory(String category);
    Ingredient getIngredientById(Long id);
}
