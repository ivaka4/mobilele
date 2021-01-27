package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.UserRole;
import bg.softuni.mobilele.models.enums.UserRoleEnum;
import bg.softuni.mobilele.repositories.UserRoleRepository;
import bg.softuni.mobilele.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedRoles() {
        UserRole admin = new UserRole(UserRoleEnum.ADMIN);
        UserRole user = new UserRole(UserRoleEnum.USER);
        userRoleRepository.save(admin);
        userRoleRepository.save(user);

    }

    @Override
    public int getRolesCount() {
        return (int) this.userRoleRepository.count();
    }

//    @Override
//    public UserRoleServiceModel findByAuthority(String role) {
//        return this.modelMapper.map(this.userRoleRepository.findByRoles(role), UserRoleServiceModel.class);
//
//    }
}
