package com.backendp4.backendp4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class RequestDto {
    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @Size(min = 4)
    private String password;

    private String email;

    public RequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RequestDto(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                '}';
    }
}
