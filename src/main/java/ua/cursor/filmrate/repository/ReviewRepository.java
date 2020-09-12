package ua.cursor.filmrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.cursor.filmrate.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
