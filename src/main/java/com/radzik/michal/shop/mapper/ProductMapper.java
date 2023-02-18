package com.radzik.michal.shop.mapper;

import com.radzik.michal.shop.domain.dao.Product;
import com.radzik.michal.shop.domain.dto.ProductDto;

import java.util.List;


public interface ProductMapper {

    ProductDto toDto (Product product);

    Product toDao (ProductDto productDto);

    List<ProductDto> toDtos(List<Product>products);


}
