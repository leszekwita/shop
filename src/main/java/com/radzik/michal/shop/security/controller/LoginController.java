package com.radzik.michal.shop.security.controller;

import com.radzik.michal.shop.domain.dto.LoginDto;
import com.radzik.michal.shop.domain.dto.TokenDto;
import com.radzik.michal.shop.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto.getEmail(), loginDto.getPassword());
    }
}
