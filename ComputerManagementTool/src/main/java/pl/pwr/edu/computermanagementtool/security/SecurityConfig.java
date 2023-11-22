package pl.pwr.edu.computermanagementtool.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(autorize -> autorize
//                .requestMatchers("/auth").permitAll()
//                .requestMatchers("/auth/login").permitAll()
//                .requestMatchers("/auth/register").permitAll()
//                .anyRequest().authenticated())
//                .csrf(csrf -> csrf.disable())
//                .formLogin(Customizer.withDefaults());
//
//        return http.build();
//
//    }


//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception{

//        return http
//                .csrf(csrf -> csrf.disable())
//
//                .authorizeRequests(auth -> {
//                  auth.requestMatchers("/").permitAll();
//                  auth.requestMatchers("/user").hasRole("User");
//                  auth.requestMatchers("/admin").hasRole("Administrator");
//                })
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/auth/login"))
//                .build();

//    }


}
