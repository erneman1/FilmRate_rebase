package ua.cursor.filmrate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.entity.Movie;
import ua.cursor.filmrate.entity.Rate;
import ua.cursor.filmrate.entity.Review;
import ua.cursor.filmrate.repository.MovieRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@RequiredArgsConstructor
public class FilmRateApplication {

    @Autowired
    private final MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(FilmRateApplication.class, args);
    }

    @PostConstruct
    void aaa() {
        Movie movie = new Movie();
        Review review = new Review();
        Category category = new Category();
        review.setId(1l);
        review.setLiked(true);
        review.setMessage("bla bla bla");
        category.setId(1L);
        category.setName("Test");
        category.setMovies(Set.of(movie));
        movie.setId(1L);
        movie.setName("Test");
        movie.setDirector("TEST");
        movie.setDescription("TEST");
        movie.setRate(new Rate(1l, 15l, 9.0d));
        movie.setReviews(List.of(review));
        movie.setCategories(Set.of(category));
        movieRepository.save(movie);
    }

}
