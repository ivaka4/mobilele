package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.User;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.repositories.UserRoleRepository;
import bg.softuni.mobilele.services.UserService;
import bg.softuni.mobilele.models.view.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerUser(UserRegisterModel userRegisterModel) {
        User user = this.modelMapper.map(userRegisterModel, User.class);
        if (userRegisterModel.getRoles().equals("ADMIN")){
            user.setAuthorities(new HashSet<>());
            user.getAuthorities().add(userRoleRepository.findById(1L).get());
        } else {
            user.setAuthorities(new HashSet<>());
            user.getAuthorities().add(userRoleRepository.findById(2L).get());
        }
        user.setCreated(Instant.now());
        user.setModified(Instant.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        long id =random.nextInt((int) (this.userRepository.count()));
        return this.userRepository.findById(id).get();
    }



}
