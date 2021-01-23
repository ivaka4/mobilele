package bg.softuni.mobilele.init;

import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.OfferService;
import bg.softuni.mobilele.services.UserRoleService;
import bg.softuni.mobilele.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;
    private final OfferService offerService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;

    @Autowired
    public DataInitializer(BrandService brandService, OfferService offerService, UserService userService, UserRoleService userRoleService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.offerService = offerService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.seedRoles();
    }
}
