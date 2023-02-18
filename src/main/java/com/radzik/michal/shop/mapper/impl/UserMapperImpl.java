//package com.radzik.michal.shop.mapper.impl;
//
//import com.radzik.michal.shop.domain.dao.User;
//import com.radzik.michal.shop.domain.dto.UserDto;
//import com.radzik.michal.shop.mapper.UserMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserMapperImpl implements UserMapper {
//
//    @Override
//    public UserDto toDto(User user) {
//        return UserDto.builder()
//                .id(user.getId())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .createdDate(user.getCreatedDate())
//                .lastModifiedDate(user.getLastModifiedDate())
//                .build();
//    }
//
//    @Override
//    public User toDao(UserDto userDto) {
//        return User.builder()
//                .id(userDto.getId())
//                .firstName(userDto.getFirstName())
//                .lastName(userDto.getLastName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .build();
//    }
//}
