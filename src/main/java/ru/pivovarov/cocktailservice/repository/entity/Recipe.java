package ru.pivovarov.cocktailservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String label;
    @Column
    private double calories;
    @OneToMany(mappedBy = "recipe",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ingredient> ingredients;

    //    private List<String> tags; TODO add search by tags

    public void addIngredientToRecipe(Ingredient ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }
}
