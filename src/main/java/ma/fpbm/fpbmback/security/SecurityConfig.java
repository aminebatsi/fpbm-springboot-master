
package ma.fpbm.fpbmback.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
/*
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private AccountService accountService;

    public SecurityConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(new UserDetailsService() {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            AppUser appUser = accountService.loadUserByUserName(username);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            appUser.getAppRoles().forEach(appRole -> {
                authorities.add(new SimpleGrantedAuthority(appRole.getRoleName()));
            });
            return new User(appUser.getUserName(), appUser.getPassword(), authorities);
        }
    });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().csrf().disable();
        //http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers("/refreshToken/**").permitAll();
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public  SecurityConfig() {
        super(true); // Disable defaults
    }
    @Override
    protected void configure(HttpSecurity http) {
        // Do nothing, this is just overriding the default behavior in WebSecurityConfigurerAdapter

    }
}