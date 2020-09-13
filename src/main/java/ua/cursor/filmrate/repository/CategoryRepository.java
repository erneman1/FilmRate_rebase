package ua.cursor.filmrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.cursor.filmrate.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getById(long id);

    @Query("from Category as c left join fetch c.movies where c.id =:id")
    Category getByIdWithMovies(long id);
}
