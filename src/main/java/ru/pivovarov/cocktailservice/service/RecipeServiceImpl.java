package ru.pivovarov.cocktailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pivovarov.cocktailservice.repository.IngredientRepository;
import ru.pivovarov.cocktailservice.repository.RecipeRepository;
import ru.pivovarov.cocktailservice.repository.entity.Ingredient;
import ru.pivovarov.cocktailservice.repository.entity.Recipe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> getRecipesByCategory(String category) {
        Set<Long> recipeIds = new HashSet<>();
        for (Ingredient ing : ingredientRepository.findByCategory(category)) {
            recipeIds.add(ing.getRecipe().getId());
        }
        return getAllByIds(recipeIds);
    }

    @Override
    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).get();
    }

    @Override
    public List<Recipe> getAllByIds(Set<Long> ids) {
        return recipeRepository.findAllById(ids);
    }
}
