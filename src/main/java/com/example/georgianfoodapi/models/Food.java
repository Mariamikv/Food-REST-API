package com.example.georgianfoodapi.models;

import com.example.georgianfoodapi.utils.DishType;
import com.example.georgianfoodapi.utils.MealType;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long foodId;
    private String title;
    private String imageUrl;
    private String SmallDesc;
    private String LongDesc;
    @Column(name = "meal_type")
    private MealType mealType;
    @Column(name = "dish_type")
    private DishType dishType;
    @OneToMany(
            mappedBy = "food",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Ingredient> ingredient; // add link of ingredients object
    @Column(name = "how_to_cook")
    private String howToCook;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "authorId"
    )
    private Author author;  // add link of author object
}
