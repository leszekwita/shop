package com.radzik.michal.shop.controller;


import com.radzik.michal.shop.domain.dto.ProductDto;
import com.radzik.michal.shop.domain.dto.UserDto;
import com.radzik.michal.shop.mapper.ProductMapper;
import com.radzik.michal.shop.mapper.UserMapper;
import com.radzik.michal.shop.service.ProductService;
import com.radzik.michal.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ProductDto saveProduct(@RequestBody ProductDto product) {

        return productMapper.toDto(productService.save(productMapper.toDao(product)));
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productMapper.toDto(productService.findProductById(id));
    }

    @GetMapping
    public Page<ProductDto> getProductPage(@RequestParam int page, @RequestParam int size) {

        return productService.getPage(PageRequest.of(page, size)).map(productMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (hasAuthority('SCOPE_ADMIN') || @securityService.hasAccesToProduct(#id))")
    public ProductDto updateProduct(@RequestBody ProductDto product, @PathVariable Long id) {

        return productMapper.toDto(productService.update(productMapper.toDao(product), id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ProductDto> getProductByUserId(@PathVariable Long userId) {
        return productMapper.toDtos(productService.findProductByUserId(userId));
    }
}

