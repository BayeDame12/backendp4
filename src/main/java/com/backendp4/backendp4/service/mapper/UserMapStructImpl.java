package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UserDto;
import com.backendp4.backendp4.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserMapStructImpl implements UserMapStruct{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserMapStructImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserDto toDto(User user) {
        UserDto newUserDto= new UserDto();
        newUserDto.setId(user.getId());
        newUserDto.setLogin(user.getLogin());
        newUserDto.setRole(user.getRole());
        newUserDto.setNom(user.getNom());
        newUserDto.setPrenom(user.getPrenom());
        return newUserDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User newUser =new User();
        newUser.setLogin(userDto.getLogin());
        newUser.setRole("admin");
        newUser.setNom(userDto.getNom());
        newUser.setPrenom(userDto.getPrenom());
        return newUser;    }
}
