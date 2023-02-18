package com.radzik.michal.shop.mapper.impl

import com.radzik.michal.shop.domain.dao.Product
import com.radzik.michal.shop.domain.dao.User
import com.radzik.michal.shop.domain.dto.ProductDto
import com.radzik.michal.shop.domain.dto.UserDto
import com.radzik.michal.shop.mapper.UserMapperImpl
import spock.lang.Specification

class UserMapperImplSpec extends Specification {

    def userMapper;

    def setup () {
        userMapper = new UserMapperImpl();
    }

    def 'should return UserDto when toDto' () {
        given:
        def user = new User(id:1, firstName:'Michał', lastName: 'Radzik', email: 'leszekwita@o2.pl', password:'12345')

        when:
        def result = userMapper.toDto(user)

        then:
        result == new UserDto(1,'Michał', 'Radzik', 'leszekwita@o2.pl', '12345', null,null,null)
    }

    def 'should return User when toDao' () {
        given:
        def userDto = new UserDto(1,'Michał', 'Radzik', 'leszekwita@o2.pl', '12345', null,null,null)

        when:
        def result = userMapper.toDao(userDto)

        then:
        result == new User(id:1, firstName:'Michał', lastName: 'Radzik', email: 'leszekwita@o2.pl', password:'12345')
    }
}
