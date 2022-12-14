package ma.fpbm.fpbmback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FpbmbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FpbmbackApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRol(new AppRole(null,"USER"));
            accountService.addNewRol(new AppRole(null,"ADMIN"));
            //accountService.addNewRol(new AppRole(null,"MANAGER"));
            //accountService.addNewRol(new AppRole(null,"SCOLARITE"));

            accountService.addNewUser(new AppUser(null,"user1","123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"admin","123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","123",new ArrayList<>()));
            //accountService.addNewUser(new AppUser(null,"user3","123",new ArrayList<>()));
            //accountService.addNewUser(new AppUser(null,"user4","123",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","USER");


        };
    }*/

}
