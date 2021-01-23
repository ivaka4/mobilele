package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.entities.UserRole;
import bg.softuni.mobilele.entities.enums.UserRoleEnum;
import bg.softuni.mobilele.repositories.UserRoleRepository;
import bg.softuni.mobilele.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void seedRoles() {
        UserRole admin = new UserRole(UserRoleEnum.ADMIN);
        UserRole user = new UserRole(UserRoleEnum.USER);
        userRoleRepository.save(admin);
        userRoleRepository.save(user);

    }
}
