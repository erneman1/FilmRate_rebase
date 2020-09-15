package ua.cursor.filmrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.entity.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("from Movie as m left join fetch m.categories where m.id =:id")
    Movie getById(long id);

    @Query("from Movie as m left join fetch m.categories left join fetch m.reviews where m.id =:id")
    Movie getByIdWithReviews(long id);

    @Query("from Movie as m left join fetch m.reviews left join fetch m.categories as c where c in :categories")
    List<Movie> getAllByCategoriesContains(List<Category> categories);
}
