package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.BaseEntity;
import bg.softuni.mobilele.entities.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
public class UserRole extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum userRole;

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserRole setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}