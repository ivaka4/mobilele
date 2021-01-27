package bg.softuni.mobilele.init;

import bg.softuni.mobilele.models.entities.*;
import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.ModelCategoryEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;
import bg.softuni.mobilele.models.enums.UserRoleEnum;
import bg.softuni.mobilele.repositories.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component

public class DataInitializer implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataInitializer.class);

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final OfferRepository offerRepository;

    public DataInitializer(BrandRepository brandRepository,
                           ModelRepository modelRepository,
                           UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           OfferRepository offerRepository) {

        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) {

        LOGGER.info("Database initializer starting...");
        if (brandRepository.count() == 0) {
            Brand ford = initFord();
            Model fiesta = initFiesta(ford);
            initEscort(ford);
            initNC750();
//            User user = initUserAndRoles();
            initRoles();
            initOffer(fiesta);
        }
        LOGGER.info("Database initializer complete...");
    }

    private Brand initFord() {
        Brand brand = new Brand();
        brand.setCreated(Instant.now());
        brand.setModified(Instant.now());
        brand.setName("Ford");
        return brandRepository.save(brand);
    }

    private Model initFiesta(Brand ford) {
        Model model = new Model();
        model.setBrand(ford);
        model.setCategory(ModelCategoryEnum.CAR);
        model.setStartYear(1976);
        model.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/2560px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        model.setName("Fiesta");
        model.setCreated(Instant.now());
        model.setModified(Instant.now());
        return modelRepository.save(model);
    }

    private Model initEscort(Brand ford) {
        Model model = new Model();
        model.setBrand(ford);
        model.setCategory(ModelCategoryEnum.CAR);
        model.setStartYear(1968);
        model.setEndYear(2000);
        model.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/1978_Ford_Escort_RS2000.jpg/1920px-1978_Ford_Escort_RS2000.jpg");
        model.setName("Escort");
        model.setCreated(Instant.now());
        model.setModified(Instant.now());
        return modelRepository.save(model);
    }

    private void initNC750() {
        Brand brand = new Brand();
        brand.setCreated(Instant.now());
        brand.setModified(Instant.now());
        brand.setName("Honda");
        brandRepository.save(brand);

        Model model = new Model();
        model.setBrand(brand);
        model.setCategory(ModelCategoryEnum.MOTORCYCLE);
        model.setStartYear(2012);
        model.setImageUrl("https://www.bultraco-sofia.bg/sites/default/files/overview_01_16.jpg");
        model.setName("NC");
        model.setCreated(Instant.now());
        model.setModified(Instant.now());
        modelRepository.save(model);
    }

    private void initRoles(){
        UserRole user = new UserRole();
        user.setAuthority(UserRoleEnum.USER);
        UserRole admin = new UserRole();
        admin.setAuthority(UserRoleEnum.ADMIN);
        userRoleRepository.saveAndFlush(admin);
        userRoleRepository.saveAndFlush(user);
    }

//    private User initUserAndRoles() {
//
//        UserRole userRole = new UserRole();
//        userRole.
//                setAuthority(UserRoleEnum.USER);
//        userRole.setCreated(Instant.now());
//        userRole.setModified(Instant.now());
//
//        UserRole adminRole = new UserRole();
//        adminRole.setAuthority(UserRoleEnum.ADMIN);
//        userRole.setCreated(Instant.now());
//        userRole.setModified(Instant.now());
//        userRole = userRoleRepository.save(userRole);
//        adminRole = userRoleRepository.save(adminRole);
//
//        User user = new User();
//        user.setFirstName("Lachezar");
//        user.setLastName("Balev");
//        user.setUsername("luchob");
//        user.setPassword("123");
//        user.setActive(true);
//        user.setImageUrl("https://avatars0.githubusercontent.com/u/10339738?s=460&u=5860fbe961c7216971cdb5102176834e3e836e64&v=4");
//        user.setCreated(Instant.now());
//        user.setModified(Instant.now());
//
//        user.setAuthorities(Set.of(userRole, adminRole));
//        return userRepository.save(user);
//    }

    private void initOffer(
            Model model) {
        Offer offer = new Offer();
        offer.setDescription("Excellent fuel economy, convenient, cheap to run, nice sound system, fun to drive around town. Well maintained, good condition.");
        offer.setEngine(EngineEnum.GASOLINE);
        offer.setImageUrl("https://i.imgur.com/hMhtVqe.jpg");
        offer.setMileage(70000);
        offer.setPrice(10000.00);
        offer.setTransmission(TransmissionEnum.MANUAL);
        offer.setYear(2016);
        offer.setModel(model);
        //setSeller(seller).
        offer.setCreated(Instant.now());
        offer.setModified(Instant.now());
        offerRepository.save(offer);
    }
}
