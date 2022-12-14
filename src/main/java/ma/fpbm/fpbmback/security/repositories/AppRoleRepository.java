package ma.fpbm.fpbmback.security.repositories;

import ma.fpbm.fpbmback.security.Beans.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    //AppRole findByRoleName(String roleName);
    AppRole findAppRoleByRoleName(String roleName);
}
