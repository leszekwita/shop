package com.radzik.michal.shop.service.impl;

import com.radzik.michal.shop.domain.dao.User;
import com.radzik.michal.shop.repository.RoleRepository;
import com.radzik.michal.shop.repository.UserRepository;
import com.radzik.michal.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        roleRepository.findByName("USER").ifPresent(role->user.setRoles(Collections.singleton(role)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User does not exist"));
    }


    @Override
    public void deleteById(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public Page<User> getPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User update(User user, Long id) {
        User userDb = findUserById(id);
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setEmail(user.getEmail());
        return save(userDb);

    }

    @Override
    public User getCurrentUser() {

        return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()->new EntityNotFoundException("User does not exist or is not logged"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new EntityNotFoundException("User does not exist or is not logged"));
    }


}
