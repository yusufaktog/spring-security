package com.aktog.yusuf.security;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*    @Bean
    public UserDetailsService getUsers() {
        UserDetails user = User.builder()
                .username("user")
                .password(bCryptPasswordEncoder().encode("123"))
                .roles(UserRole.ROLE_USER.getRole())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder().encode("admin123"))
                .roles(UserRole.ROLE_ADMIN.getRole())
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        security
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x -> x.requestMatchers("/user/**").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/greeting/**").permitAll())
                .authorizeHttpRequests(x -> x.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return security.build();
    }

}
