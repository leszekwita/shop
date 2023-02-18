package com.radzik.michal.shop.repository;

import com.radzik.michal.shop.domain.dao.Product;
import com.radzik.michal.shop.domain.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
     List<Product> findProductByUserId(Long userId);
     Optional<Product> findByIdAndUserId(Long productId, Long userId);
}
