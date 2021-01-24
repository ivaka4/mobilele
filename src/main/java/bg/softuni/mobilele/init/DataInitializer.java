package bg.softuni.mobilele.init;

import bg.softuni.mobilele.entities.User;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.OfferService;
import bg.softuni.mobilele.services.UserRoleService;
import bg.softuni.mobilele.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public DataInitializer(BrandService brandService, OfferService offerService,
        UserService userService, UserRoleService userRoleService, ModelMapper modelMapper,
        PasswordEncoder passwordEncoder,
        UserRepository userRepository) {
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.seedRoles();
        if (userRepository.count() == 0) {
            seedAdmin();
        }
    }

    private void seedAdmin() {
        User userEntity = new User();

        userEntity.setFirstName("Редник");
        userEntity.setLastName("Текерлеков");
        userEntity.setUsername("admin");
        userEntity.setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(userEntity);
    }
}
