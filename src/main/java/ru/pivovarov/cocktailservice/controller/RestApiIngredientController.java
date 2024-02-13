package ru.pivovarov.cocktailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pivovarov.cocktailservice.repository.entity.Ingredient;
import ru.pivovarov.cocktailservice.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class RestApiIngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public RestApiIngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getIngredients(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) String category) {
        List<Ingredient> result;
        if (name != null && category != null) {
            result = ingredientService.getIngredients();
        } else if (name != null) {
            result = ingredientService.getIngredientsByName(name);
        } else if (category != null) {
            result = ingredientService.getIngredientsByCategory(category);
        } else {
            result = ingredientService.getIngredients();
        }
        return result;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }
}
