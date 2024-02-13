package ru.pivovarov.cocktailservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;
    @Column
    private String text;
    @Column
    private int quantity;
    @Column
    private String measure;
    @Column
    private String name;
    @Column
    private String category;
}
