package bg.softuni.mobilele.models.entities;

import bg.softuni.mobilele.models.enums.UserRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class UserRole extends BaseEntity implements GrantedAuthority {

    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum authority;

    public UserRole(UserRoleEnum userRole) {
        this.authority = userRole;
    }

    @Override
    @Column(name = "roles", nullable = false, unique = true)
    public String getAuthority() {
        return authority.name();
    }

    public void setRoles(UserRoleEnum roles) {
        this.authority = roles;
    }
}