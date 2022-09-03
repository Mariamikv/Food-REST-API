package com.example.georgianfoodapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    private List<Ingredient> ingredient; // add link of ingredients object
    @Column(name = "how_to_cook")
    private String howToCook;
    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "authorId"
    )
    @JsonIgnore
    private Author author;  // add link of author object

    public Food(String title, String imageUrl, String smallDesc, String longDesc, String mealType, String dishType, String howToCook, Author author) {
        this.title = title;
        this.imageUrl = imageUrl;
        SmallDesc = smallDesc;
        LongDesc = longDesc;
        this.mealType = mealType;
        this.dishType = dishType;
        this.howToCook = howToCook;
        this.author = author;
    }
}
