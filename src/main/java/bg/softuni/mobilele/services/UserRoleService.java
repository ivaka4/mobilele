package bg.softuni.mobilele.services;

public interface UserRoleService {
    void seedRoles();

//    UserRoleServiceModel findByAuthority(String role);
    int getRolesCount();
}
