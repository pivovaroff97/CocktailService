package ru.pivovarov.cocktailservice.service;

import ru.pivovarov.cocktailservice.repository.entity.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    List<Recipe> getRecipes();
    List<Recipe> getRecipesByCategory(String category);
    Recipe getRecipeById(Long recipeId);
    List<Recipe> getAllByIds(Set<Long> ids);
}
