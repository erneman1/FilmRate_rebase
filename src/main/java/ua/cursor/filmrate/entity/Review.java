package ua.cursor.filmrate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "movie_id")
    @JsonProperty("movie")
    private Movie movie;
    private String message;
    private Boolean liked;
}
