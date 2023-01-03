package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UserDto;
import com.backendp4.backendp4.model.User;

public interface UserMapStruct {
    //Mappage d l entity User

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
