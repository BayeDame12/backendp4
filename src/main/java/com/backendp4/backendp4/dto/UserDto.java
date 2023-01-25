package com.backendp4.backendp4.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class UserDto {
    private Long id;
    @NotBlank
    private String login;
    private String role;
    private String prenom;
    private String nom;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
