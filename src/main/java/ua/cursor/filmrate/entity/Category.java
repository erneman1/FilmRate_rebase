package ua.cursor.filmrate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"}, callSuper = false)
@ToString(of = {"id", "name"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Movie> movies = new HashSet<>();
}
