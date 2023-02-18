package com.radzik.michal.shop.mapper;

import com.radzik.michal.shop.domain.dao.User;
import com.radzik.michal.shop.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="password", ignore = true)
    UserDto toDto (User user);

    User toDao (UserDto userDto);
}
