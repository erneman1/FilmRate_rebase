package ua.cursor.movieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cursor.movieplatform.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
