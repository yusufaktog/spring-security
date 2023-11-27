package com.aktog.yusuf;

import com.aktog.yusuf.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityTrialApplication implements CommandLineRunner {

    private final UserService userService;

    public SecurityTrialApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityTrialApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*
        System.out.println("=>");
        userService.createUser(new CreateUserRequest("yusuf","test","123", Set.of(UserRole.ROLE_USER)));
        userService.createUser(new CreateUserRequest("yusuf","admin","123", Set.of(UserRole.ROLE_ADMIN)));
        userService.createUser(new CreateUserRequest("yusuf","eng","123", Set.of(UserRole.ROLE_ENGINEER)));

*/

    }
}
