package ua.cursor.filmrate.entity.enums;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return Set.of(new SimpleGrantedAuthority(name));
    }
}
