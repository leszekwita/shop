package com.radzik.michal.shop.controller

import com.radzik.michal.shop.domain.dao.User
import com.radzik.michal.shop.domain.dto.UserDto
import com.radzik.michal.shop.mapper.UserMapper
import com.radzik.michal.shop.mapper.UserMapperImpl
import com.radzik.michal.shop.repository.UserRepository
import com.radzik.michal.shop.service.ProductService
import com.radzik.michal.shop.service.UserService
import com.radzik.michal.shop.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = 'classpath:application-test.yml')
@ActiveProfiles("test")
class UserControllerIT extends Specification {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository

    @WithMockUser
    def 'when get is performed then the response has status 200'() {

        given:
        User user = userRepository.save(User.builder().firstName('Michal').lastName('Radzik').email('leszekwita@o2.pl').build())
        when:

        def response = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/"+user.getId()))

        then:
        response.andExpect(status().isOk())

    }

    @WithMockUser
    def 'when get is performed then the response has status 2002'() {

        given:
        User user = userRepository.save(User.builder().firstName('Michal').lastName('Radzik').email('leszekwita@o2.pl').build())
        when:

        def response = mockMvc.perform(MockMvcRequestBuilders.post("/api/users/"),content:  [firstName: 'Michal', lastName: 'Radzik', email:'leszekwita@o2.pl'])

        then:
        response.andExpect(status().isOk())

    }
}

