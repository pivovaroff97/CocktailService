package ru.pivovarov.cocktailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pivovarov.cocktailservice.repository.IngredientRepository;
import ru.pivovarov.cocktailservice.repository.entity.Ingredient;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getIngredientsByName(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public List<Ingredient> getIngredientsByCategory(String category) {
        return ingredientRepository.findByCategory(category);
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).get();//TODO do return if ingredient not found
    }
}
