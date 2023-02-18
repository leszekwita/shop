package com.radzik.michal.shop.service;

import com.radzik.michal.shop.domain.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User save (User user);

    User findUserById(Long id);

    void deleteById(Long id);

    Page<User> getPage(Pageable pageable);

    User update(User user, Long id);

    User getCurrentUser();

    User findByEmail (String email);

}
