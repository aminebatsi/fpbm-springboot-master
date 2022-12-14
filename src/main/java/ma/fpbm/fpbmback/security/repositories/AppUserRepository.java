package ma.fpbm.fpbmback.security.repositories;

import ma.fpbm.fpbmback.security.Beans.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
