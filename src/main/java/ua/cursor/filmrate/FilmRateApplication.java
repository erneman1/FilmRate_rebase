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
import ua.cursor.filmrate.service.CategoryService;
import ua.cursor.filmrate.service.MovieService;
import ua.cursor.filmrate.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@RequiredArgsConstructor
public class FilmRateApplication {

    private final UserService userService;
    private final MovieService movieService;
    private final CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(FilmRateApplication.class, args);
    }

    @PostConstruct
    void aaa() {
        userService.save(new User(
                null,
                "user",
                "user",
                "$2y$12$7AcCI6hb8d49xum72Eo3FuLXKsGHm7lWswiHmR29no9bfYe8/me5a",
                Role.ROLE_ADMIN
        ));

        userService.save(new User(
                null,
                "admin",
                "admin",
                "$2y$12$1C2lTYmL2As6VnX4BggJdeEZWo5u1GNB56HsWwZY8.aarE06g/JKu",
                Role.ROLE_USER
        ));


        movieService.save(
                new Movie(
                        null,
                        "Very interesting movie",
                        "Cool director",
                        "Very long and interesting description",
                        new Rate(null, 158L, 5.5),
                        new ArrayList<>(),
                        Set.copyOf(categoryService.getAll())
                )
        );
    }

}
