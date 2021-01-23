package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

//    UserRole findByRole(String role);
}
