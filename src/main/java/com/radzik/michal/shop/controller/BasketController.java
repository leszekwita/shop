package com.radzik.michal.shop.controller;

import com.radzik.michal.shop.domain.dto.ProductDto;
import com.radzik.michal.shop.domain.dto.UserDto;
import com.radzik.michal.shop.mapper.ProductMapper;
import com.radzik.michal.shop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public List<ProductDto> getAllProductsBasket() {

        return productMapper.toDtos(basketService.getAllProducts());
    }
}
