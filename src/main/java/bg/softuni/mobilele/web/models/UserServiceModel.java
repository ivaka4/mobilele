package bg.softuni.mobilele.web.models;

import bg.softuni.mobilele.entities.enums.UserRoleEnum;

import java.util.Set;

public class UserServiceModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Set<UserRoleEnum> roles;



    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<UserRoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleEnum> roles) {
        this.roles = roles;
    }
}
