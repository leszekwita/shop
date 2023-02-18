package com.radzik.michal.shop.validator.impl

import com.radzik.michal.shop.domain.dto.UserDto
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SamePasswordValidatorSpec extends Specification{

    def samePasswordValidator = new SamePasswordValidator()

    def 'should Test Password Validator'(){
        given:
        UserDto userDto = new UserDto(password:password,confirmPassword: confirmPassword)

        when:
        def result = samePasswordValidator.isValid(userDto, null)

        then:
        result == expected

        where:
        password | confirmPassword || expected
        'abc' | 'cba' || false
        'abc' | 'abc' || true
    }
}
