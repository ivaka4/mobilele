package bg.softuni.mobilele.models.view;


public class UserRegisterModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String roles;

    public UserRegisterModel() {
    }

    public UserRegisterModel(java.lang.String firstName, java.lang.String lastName, java.lang.String username, java.lang.String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
