package com.radzik.michal.shop.security

import com.radzik.michal.shop.domain.dao.Product
import com.radzik.michal.shop.domain.dao.User
import com.radzik.michal.shop.security.service.SecurityService
import com.radzik.michal.shop.service.UserService
import com.radzik.michal.shop.service.ProductService
import spock.lang.Specification

class SecurityServiceSpec extends Specification {

    def securityService
    def userService = Mock(UserService)
    def productService = Mock(ProductService)

    def setup() {
        securityService = new SecurityService(userService, productService);
    }

    def 'should return true when hasAccessToUser'() {
        given:
        Long id = 1;
        userService.getCurrentUser() >> new User(id: 1, firstName: 'Michał', lastName: 'Radzik', email: 'leszekwita@o2.pl', password: '12345')

        when:
        def result = securityService.hasAccessToUser(1)

        then:
        result == true

    }

    def 'should return true when hasAccesToProduct'() {
        given:
        Product product = new Product(id: 1, name: 'bicycle', price: 300)
        userService.getCurrentUser() >> new User(id: 1, firstName: 'Michał', lastName: 'Radzik', email: 'leszekwita@o2.pl', password: '12345')

        when:
        def result = securityService.hasAccesToProduct(product.getId())

        then:
        result == true
    }
}