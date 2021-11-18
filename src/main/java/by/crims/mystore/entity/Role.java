package by.crims.mystore.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, SELLER;

    @Override
    public String getAuthority() {
        return name();
    }
}
