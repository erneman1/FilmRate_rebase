package ua.cursor.filmrate;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.entity.Movie;
import ua.cursor.filmrate.entity.Rate;
import ua.cursor.filmrate.entity.User;
import ua.cursor.filmrate.entity.enums.Role;
import ua.cursor.filmrate.repository.CategoryRepository;
import ua.cursor.filmrate.repository.MovieRepository;
import ua.cursor.filmrate.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@RequiredArgsConstructor
public class FilmRateApplication {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(FilmRateApplication.class, args);
    }

    @PostConstruct
    void aaa() {
        userRepository.save(new User(
                null,
                "user",
                "user",
                "$2y$12$7AcCI6hb8d49xum72Eo3FuLXKsGHm7lWswiHmR29no9bfYe8/me5a",
                Role.ROLE_USER
        ));

        userRepository.save(new User(
                null,
                "admin",
                "admin",
                "$2y$12$1C2lTYmL2As6VnX4BggJdeEZWo5u1GNB56HsWwZY8.aarE06g/JKu",
                Role.ROLE_ADMIN
        ));

        categoryRepository.save(new Category(null, "Horror", new HashSet<>()));
        categoryRepository.save(new Category(null, "Detective", new HashSet<>()));
        categoryRepository.save(new Category(null, "Drama", new HashSet<>()));
        categoryRepository.save(new Category(null, "Comedy", new HashSet<>()));
        categoryRepository.save(new Category(null, "Fantastic", new HashSet<>()));
        categoryRepository.save(new Category(null, "Fantasy", new HashSet<>()));
        categoryRepository.save(new Category(null, "Thriller", new HashSet<>()));
        categoryRepository.save(new Category(null, "Action", new HashSet<>()));
        categoryRepository.save(new Category(null, "Travel", new HashSet<>()));


        movieRepository.save(
                new Movie(
                        null,
                        "The Devil All The Time",
                        "Tom Holland",
                        "Sinister characters converge around a young man devoted to protecting those he loves in a postwar backwoods town teeming with corruption and brutality.",
                        new Rate(null, 100L, 10.0),
                        new ArrayList<>(),
                        Set.copyOf(categoryRepository.findAll())
                )
        );

        movieRepository.save(
                new Movie(
                        null,
                        "Very interesting movie ",
                        "Cool director",
                        "Very long and interesting description",
                        new Rate(null, 0L, 0.0),
                        new ArrayList<>(),
                        Set.copyOf(categoryRepository.findAll())
                )
        );


    }

}
