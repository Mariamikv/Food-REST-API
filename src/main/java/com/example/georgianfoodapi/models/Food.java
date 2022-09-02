package com.example.georgianfoodapi.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

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
    private String mealType;
    @Column(name = "dish_type")
    private String dishType;
    @OneToMany(
            mappedBy = "food",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
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
