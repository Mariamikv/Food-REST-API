package com.example.georgianfoodapi.models;

import com.example.georgianfoodapi.utils.MeasureType;
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
    private MeasureType measureType;
    private float weight;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "food_id",
            referencedColumnName = "foodId"
    )
    private Food food;
}

