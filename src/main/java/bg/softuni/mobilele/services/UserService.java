package bg.softuni.mobilele.services;

import bg.softuni.mobilele.entities.User;
import bg.softuni.mobilele.entities.view.UserRegisterModel;
import bg.softuni.mobilele.entities.view.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
