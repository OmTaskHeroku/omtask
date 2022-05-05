package com.example.omtask.Users;

import com.example.omtask.Instances.InstanceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {

//    @Bean
//    CommandLineRunner CLR(UserRepository userRepository, RoleRepository roleRepository, UserService userService){
//        return args -> {
//            Role r1 = new Role(null, "ROLE_LEADER", new ArrayList<>());
//            Role r2 = new Role(null, "ROLE_USER", new ArrayList<>());
//            Role r3 = new Role(null, "ROLE_OWNER", new ArrayList<>());
//            Role r4 = new Role(null, "ROLE_GUEST", new ArrayList<>());
//
//            try {
//                roleRepository.saveAll(List.of(r1,r2,r3,r4));
//            } catch (Exception e) {
//                System.out.println("Role error");
//            }
//
//
//            User user = new User(null, "Jan", "Grzesznik",
//                    "test", "test@wp.pl",
//                    "$2a$12$GENgy8hg5aA7nL8fv3xUoeMdyDgcnj0RpNHWQ0uLhR/ExGfJmdBzC",
//                    null, null, null, null, null);
//
//            try {
//                userRepository.save(user);
//            } catch (Exception e) {
//                System.out.println("User error");
//            }
//
//            userService.addRoleToUser("test","ROLE_USER");
//        };
//    }

//    @Bean
//    CommandLineRunner CLR(InstanceService instanceService){
//        return args -> {
//
//        };
//    }
}
