package com.radzik.michal.shop.repository;

import com.radzik.michal.shop.domain.dao.Basket;
import com.radzik.michal.shop.domain.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket,Long> {

    void deleteByProductIdAndUserId(Long productId,Long userId);
    List<Basket> findByUserId(Long userId);
    Optional<Basket> findByUserIdAndProductId(Long userId, Long productId);

}
