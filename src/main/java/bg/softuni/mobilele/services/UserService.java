package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.entities.User;
import bg.softuni.mobilele.models.view.UserRegisterModel;

import java.util.Collection;

public interface UserService {

    void registerUser(UserRegisterModel userRegisterModel);
    Collection<User> getUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
    User updateUser(User user);
    User deleteUser(Long id);
    User getRandomUser();

}
