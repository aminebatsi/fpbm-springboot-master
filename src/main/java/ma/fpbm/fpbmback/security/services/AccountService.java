package ma.fpbm.fpbmback.security.services;

import ma.fpbm.fpbmback.security.Beans.AppRole;
import ma.fpbm.fpbmback.security.Beans.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRol(AppRole appRole);
    void addRoleToUser(String userName,String roleName);
    AppUser loadUserByUserName(String userName);
    List<AppUser> listUsers();
}
