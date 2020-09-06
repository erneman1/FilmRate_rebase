package ua.cursor.filmrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.cursor.filmrate.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("from Movie as m left join fetch m.reviews where m.id =:id")
    Movie getById(long id);

}
