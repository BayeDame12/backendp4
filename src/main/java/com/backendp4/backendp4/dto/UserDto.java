package com.backendp4.backendp4.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class UserDto {

    private String login;
    private String password;
}
