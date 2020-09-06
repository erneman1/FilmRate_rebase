package ua.cursor.movieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cursor.movieplatform.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User as u left join fetch u.userRoles ")
    List<User> findAllWithRoles();

    User findById(long id);
}
