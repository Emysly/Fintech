package com.emysilva.fintech;

import com.emysilva.fintech.entities.Role;
import com.emysilva.fintech.entities.User;
import com.emysilva.fintech.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class FintechApplication {
    public static void main(String[] args) {
        SpringApplication.run(FintechApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_MANAGER"));
            userService.saveRole(new Role("ROLE_ADMIN"));
            userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

            userService.saveUser(new User("00000000000", "0000", "johnt@gmail.com", "John Travolta", "JohnT", new ArrayList<>()));
            userService.saveUser(new User("11111111111", "1111", "wills@gmail.com", "Will Smith", "WillS", new ArrayList<>()));
            userService.saveUser(new User("22222222222", "2222", "jimc@gmail.com", "Jim Carry", "JimC", new ArrayList<>()));
            userService.saveUser(new User("33333333333", "3333", "anorlds@gmail.com", "Anorld Schwarzenegger", "AnorldS", new ArrayList<>()));

            userService.addRoleToUser("00000000000", "ROLE_USER");
            userService.addRoleToUser("00000000000", "ROLE_MANAGER");
            userService.addRoleToUser("11111111111", "ROLE_USER");
            userService.addRoleToUser("11111111111", "ROLE_MANGER");
            userService.addRoleToUser("11111111111", "ROLE_ADMIN");
            userService.addRoleToUser("22222222222", "ROLE_USER");
            userService.addRoleToUser("22222222222", "ROLE_MANGER");
            userService.addRoleToUser("22222222222", "ROLE_ADMIN");
            userService.addRoleToUser("22222222222", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("33333333333", "ROLE_USER");
        };
    }
}
