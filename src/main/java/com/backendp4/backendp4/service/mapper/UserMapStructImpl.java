package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UserDto;
import com.backendp4.backendp4.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service

public class UserMapStructImpl implements UserMapStruct {
    private final ModelMapper modelMapper;

    public UserMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
