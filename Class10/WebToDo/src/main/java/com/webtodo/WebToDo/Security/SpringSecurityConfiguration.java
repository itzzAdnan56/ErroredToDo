package com.webtodo.WebToDo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ContentSecurityPolicyHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
//    InMemoryUserDetailsManager(UserDetailsManager... users);

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails userDetails1 = AddNewUserDetails("Adnan1", "12345");
        UserDetails userDetails2 = AddNewUserDetails("Adnan2", "12345");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails AddNewUserDetails(String username, String password) {
        Function<String,String> passwordEncoder  = input->passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher optionsMatcher = new AntPathRequestMatcher("/**", HttpMethod.OPTIONS.toString());
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(optionsMatcher).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/LoginPage")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/**")).authenticated());

        http.csrf(csrf -> csrf.disable());

        http.headers(headers -> headers.addHeaderWriter(new ContentSecurityPolicyHeaderWriter("frame-ancestors 'self'")));

        http.httpBasic(withDefaults());

        return http.build();
    }
}
