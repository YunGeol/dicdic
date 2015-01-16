package dicdic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties security;

    @Autowired
    private DataSource dataSource;

    @Value("${REMEMBERME_KEY}")
    private String REMEMBERME_KEY;

    @Value("${PASS_ENC_KEY}")
    private String PASS_ENC_KEY;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/home").access("hasRole('ROLE_USER') and fullyAuthenticated")
                .anyRequest().fullyAuthenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling().accessDeniedPage("/access?error")
                .and().rememberMe().key(REMEMBERME_KEY).tokenValiditySeconds(600)
                .and().csrf().disable()
        ;
    }



    @Bean
    public JdbcUserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        manager.setEnableGroups(true);

        /*
        manager.setUsersByUsernameQuery(
                "select username,password,enabled from users where username=?");
        manager.setAuthoritiesByUsernameQuery(
                "select username, role from user_roles where username=?");
        manager.setRolePrefix("ROLE_");
        */
        return manager;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder(PASS_ENC_KEY);
    }



    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setEnableGroups(true);
        */

        //PasswordEncoder encoder = new BCryptPasswordEncoder();
        PasswordEncoder encoder = passwordEncoder();

        JdbcUserDetailsManager jdbcUserDetailsManager = userDetailsManager();

        auth.userDetailsService( jdbcUserDetailsManager ).passwordEncoder( encoder );
        auth.jdbcAuthentication().dataSource(dataSource);


        if(!jdbcUserDetailsManager.userExists("user")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            User userDetails = new User("user", encoder.encode("password"), authorities);
            jdbcUserDetailsManager.createUser(userDetails);

            userDetails = new User("admin", encoder.encode("password"), authorities);
            jdbcUserDetailsManager.createUser(userDetails);
        }


    }





}
