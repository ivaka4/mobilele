package bg.softuni.mobilele.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {
    @Column(nullable = false, unique = true)
    private java.lang.String username;
    @Column(name = "first_name",nullable = false)
    private java.lang.String firstName;
    @Column(name = "last_name", nullable = false)
    private java.lang.String lastName;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(nullable = false)
    private java.lang.String password;

    @ManyToMany
    private Set<UserRole> roles;

    @Column(name = "image_url")
    private java.lang.String imageUrl;

    @OneToMany(mappedBy = "seller")
    private List<Offer> offer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> role.toString() + "_ROLE")
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
