package BE.MyRoute.config.auth;

import BE.MyRoute.config.auth.PrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true , prePostEnabled = true) // sercured 어노테이션 활성화 , preAuthorize+postAuthorize 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //@Bean
    //public UserDetailsService userDetailsService() {
    //    return new PrincipalDetailsService();
    //}
//
    //@Bean
    //public BCryptPasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                ;


    }
}
