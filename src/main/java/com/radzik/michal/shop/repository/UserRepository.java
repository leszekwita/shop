package com.radzik.michal.shop.repository;

import com.radzik.michal.shop.domain.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail (String email);


}
