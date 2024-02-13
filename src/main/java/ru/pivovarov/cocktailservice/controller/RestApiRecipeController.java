package ru.pivovarov.cocktailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pivovarov.cocktailservice.repository.entity.Recipe;
import ru.pivovarov.cocktailservice.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RestApiRecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RestApiRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes(@RequestParam(required = false) String category) {
        if (category != null) {
            return recipeService.getRecipesByCategory(category);
        } else {
            return recipeService.getRecipes();
        }
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        System.out.println("recipe by id: " + recipe.getId() + " " + recipe.getLabel());
        return recipe;
    }
}
