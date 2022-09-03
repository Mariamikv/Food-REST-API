package com.example.georgianfoodapi.models;

import com.example.georgianfoodapi.utils.MeasureType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inredients")
public class Ingredient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long ingredientsId;
    private String title;
    private float quantity; //Quantity of specified measure
    private String measureType;
    private float weight;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "food_id",
            referencedColumnName = "foodId"
    )
    @JsonIgnore
    private Food food;

    public Ingredient(String title, float quantity, String measureType, float weight, Food food) {
        this.title = title;
        this.quantity = quantity;
        this.measureType = measureType;
        this.weight = weight;
        this.food = food;
    }
}

