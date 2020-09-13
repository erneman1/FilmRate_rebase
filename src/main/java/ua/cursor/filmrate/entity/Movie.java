package ua.cursor.filmrate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
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

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinTable(name = "movie_reviews", joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "review_id")})
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
