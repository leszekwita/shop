package com.radzik.michal.shop.service.impl

import com.radzik.michal.shop.domain.dao.Basket
import com.radzik.michal.shop.domain.dao.Product
import com.radzik.michal.shop.domain.dao.User
import com.radzik.michal.shop.exception.QuantityNotEnoughException
import com.radzik.michal.shop.repository.BasketRepository
import com.radzik.michal.shop.service.BasketService
import com.radzik.michal.shop.service.ProductService
import com.radzik.michal.shop.service.UserService
import spock.lang.Specification

class BasketServiceImplSpec extends Specification {

    def basketService
    def productService = Mock(ProductService)
    def userService = Mock(UserService)
    def basketRepository = Mock(BasketRepository)

    def setup () {
        basketService = new BasketServiceImpl(productService, userService,basketRepository);
    }

    def 'should throw exception when amount is not enough'(){
        given:
        def product = new Product(id:1,amount:400)
        productService.findProductById(1) >> new Product(amount:300)

        when:
        basketService.save(product)

        then:
        thrown QuantityNotEnoughException

    }

    def 'should add product to basket'(){
        given:
        def product = new Product(id:1,amount:400)
        def basket = new Basket(user:new User(), amount: 400,product: new Product(amount:400))

        when:
        basketService.save(product)

        then:
        1 * userService.getCurrentUser() >> new User()
        1 * productService.findProductById(product.id) >> new Product(amount: 400)
        1 * basketRepository.save(basket)
        0 * _


    }
}
