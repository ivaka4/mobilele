package bg.softuni.mobilele.services;

import bg.softuni.mobilele.entities.User;
import bg.softuni.mobilele.web.models.UserRegisterModel;
import bg.softuni.mobilele.web.models.UserServiceModel;

import java.util.Collection;

public interface UserService {

    UserServiceModel registerUser(UserRegisterModel userRegisterModel);
    Collection<User> getUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
    User updateUser(User user);
    User deleteUser(Long id);
    long getUsersCount();
}
