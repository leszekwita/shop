package com.radzik.michal.shop.config;

import com.radzik.michal.shop.domain.dao.Role;
import com.radzik.michal.shop.repository.RoleRepository;
import com.radzik.michal.shop.service.impl.WatcherServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class AppConfig {

    private static final List<String> ROLES = Arrays.asList("ROLE_USER","ROLE_ADMIN");


    @Bean
    public CommandLineRunner commandLineRunner(RoleRepository roleRepository, WatcherServiceImpl watcherService){
        return args -> {


            addRole(roleRepository,ROLES);
            new Thread(watcherService, "watcher-service").start();

        };
    }

    private void addRole(RoleRepository roleRepository, List<String> roles) {
        for (String role : roles) {
            Optional<Role> optionalRole = roleRepository.findByName(role);
            if(!optionalRole.isPresent()){
                roleRepository.save(new Role(null,role));
            }
        }

    }

    //@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
