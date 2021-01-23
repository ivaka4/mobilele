package bg.softuni.mobilele.web.models;

import bg.softuni.mobilele.entities.enums.UserRoleEnum;

public class UserRegisterModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserRoleEnum roles;

    public UserRegisterModel() {
    }

    public UserRegisterModel(String firstName, String lastName, String username, String password, UserRoleEnum roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public UserRoleEnum getRoles() {
        return roles;
    }

    public void setRoles(UserRoleEnum roles) {
        this.roles = roles;
    }
}
