package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.entities.User;
import bg.softuni.mobilele.entities.view.UserSecurity;
import bg.softuni.mobilele.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(s);
        user.orElseThrow(() -> new UsernameNotFoundException(s));
        return user.map(UserSecurity::new).get();
    }
}
