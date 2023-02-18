package com.radzik.michal.shop.service;

import com.radzik.michal.shop.domain.dao.Product;

import java.util.List;

public interface BasketService {
    void save(Product product);
    void deleteProductFromBasket(Long productId);
    void update(Product product);
    List<Product> getAllProducts();
}
