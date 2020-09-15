package ua.cursor.filmrate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import ua.cursor.filmrate.entity.enums.Role;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(of = {"login"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "login", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserDetails getUserDetails() {
        return new org.springframework.security.core.userdetails.User(
                this.login, this.password, this.role.getAuthorities()
        );
    }
}
