package com.radzik.michal.shop.mapper.impl

import com.radzik.michal.shop.domain.dao.Product
import com.radzik.michal.shop.domain.dto.ProductDto
import spock.lang.Specification
import spock.lang.Unroll


class ProductMapperImplSpec extends Specification {

    def productMapper;

    def setup () {
        productMapper = new ProductMapperImpl();
    }

    def 'should return ProductDto when toDto' () {
        given:
        def product = new Product(id:1,name:'bicycle',price:300)

        when:
        def result = productMapper.toDto(product)

        then:
        result == new ProductDto(1,'bicycle', 300,null,null,null)
    }

    def 'should return Product when toDao' () {
        given:
        def productDto = new ProductDto(1,'bicycle', 300,null,null,null)

        when:
        def result = productMapper.toDao(productDto)

        then:
        result == new Product(id:1,name:'bicycle',price:300)
    }

    def 'should return productDtos when toDtos' () {
        given:
        List<Product> products = [new Product(id:1,name:'bicycle',price:300)]

        when:
        def result = productMapper.toDtos(products)

        then:
        result == [new ProductDto(1,'bicycle', 300,null,null,null)]
    }
}
