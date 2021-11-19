package by.crims.mystore.entity;

import by.crims.mystore.utils.ErrorMessageManager;
import by.crims.mystore.utils.Patterns;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sellers")
@Builder
public class Seller implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    @Size(min = 2, max = 30, message = ErrorMessageManager.NAME_USER_ERROR)
    private String nameOfTheOrganization;
    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    @Size(min = 6, max = 100,  message = ErrorMessageManager.EMAIL_USER_ERROR)
    @Pattern(regexp = Patterns.EMAIL, message = ErrorMessageManager.EMAIL_USER_ERROR)
    private String email;
    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    @Pattern(regexp = Patterns.PASSWORD, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;
    @NotBlank
    @Size(min = 9, max = 12, message = ErrorMessageManager.SIZE_ERROR)
    private String telephone;
    private String picture;
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return nameOfTheOrganization;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
