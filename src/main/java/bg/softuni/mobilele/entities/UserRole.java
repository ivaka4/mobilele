package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.BaseEntity;
import bg.softuni.mobilele.entities.enums.UserRoleEnum;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
public class UserRole extends BaseEntity implements GrantedAuthority {

    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum userRole;

    public UserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }
    @Override
    @Column(name = "roles", nullable = false, unique = true)
    public String getAuthority() {
        return userRole.name();
    }
}