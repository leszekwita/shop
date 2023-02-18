package com.radzik.michal.shop.service.impl;

import com.radzik.michal.shop.domain.dao.Basket;
import com.radzik.michal.shop.domain.dao.Product;
import com.radzik.michal.shop.domain.dao.User;
import com.radzik.michal.shop.exception.QuantityNotEnoughException;
import com.radzik.michal.shop.repository.BasketRepository;
import com.radzik.michal.shop.service.BasketService;
import com.radzik.michal.shop.service.ProductService;
import com.radzik.michal.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {

    private final ProductService productService;

    private final UserService userService;

    private final BasketRepository basketRepository;


    @Override
    public void save(Product product) {
        User currentUser = userService.getCurrentUser();
        Product productDb = productService.findProductById(product.getId());
        if(productDb.getAmount() < product.getAmount()){
            throw new QuantityNotEnoughException("You try add more product than is in warehouse");
        }

        basketRepository.save(Basket.builder()
                .user(currentUser)
                .amount(product.getAmount())
                .product(productDb)
                .build());
    }

    @Override
    public void deleteProductFromBasket(Long productId) {
        User currentUser = userService.getCurrentUser();
        basketRepository.deleteByProductIdAndUserId(productId, currentUser.getId());
    }

    @Override
    public void update(Product product) {
        User currentUser = userService.getCurrentUser();
        Product productDb = productService.findProductById(product.getId());
        Basket basket = basketRepository.findByUserIdAndProductId(currentUser.getId(), productDb.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product does not exist in Basket"));
        if (productDb.getAmount() >= product.getAmount()) {
            basketRepository.save(basket.toBuilder()
                    .amount(product.getAmount())
                    .build());
        } else {
            throw new QuantityNotEnoughException("There is not enough products in db");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        User currentUser = userService.getCurrentUser();
        List<Basket> baskets = basketRepository.findByUserId(currentUser.getId());
        return baskets.stream()
                .map(Basket::getProduct)
            .collect(Collectors.toList());
}
}