package bg.softuni.mobilele.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> authorities;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private List<Offer> offer;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    @Transient
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    @Transient
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    @Transient
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    @Transient
//    public boolean isEnabled() {
//        return true;
//    }
}
