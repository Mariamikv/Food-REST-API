package com.example.georgianfoodapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long authorId;
    private String firstName;
    private String lastName;
    private String username;
    @OneToMany(
            mappedBy = "author",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Food> food;
}
