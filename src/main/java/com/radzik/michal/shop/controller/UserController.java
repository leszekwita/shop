package com.radzik.michal.shop.controller;

import com.radzik.michal.shop.domain.dao.User;
import com.radzik.michal.shop.domain.dto.UserDto;
import com.radzik.michal.shop.mapper.UserMapper;
import com.radzik.michal.shop.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public UserDto saveUser(@RequestBody @Valid UserDto user) {

        return userMapper.toDto(userService.save(userMapper.toDao(user)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.toDto(userService.findUserById(id));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public Page<UserDto> getUserPage(@RequestParam int page, @RequestParam int size) {

        return userService.getPage(PageRequest.of(page, size)).map(userMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN') || @securityService.hasAccessToUser(#id)")
    public UserDto updateUser(@RequestBody UserDto user, @PathVariable Long id) {
        return userMapper.toDto(userService.update(userMapper.toDao(user), id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/loggedUser")
    @PreAuthorize("isAuthenticated()")
    public UserDto getCurrentLoggedUser(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.findByEmail(email);
            return userMapper.toDto(user);
        }
        return null;

    }
}
