package com.backendp4.backendp4.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class UserDto {
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private String role;

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
