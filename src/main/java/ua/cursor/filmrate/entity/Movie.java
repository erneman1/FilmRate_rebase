package ua.cursor.filmrate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor
@ToString(of = {"id", "name", "director", "description", "rate", "categories"})
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String director;
    private String description;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id")
    private Rate rate = new Rate();

    @OneToMany(mappedBy = "movie",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_category",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Category> categories = new HashSet<>();
}
