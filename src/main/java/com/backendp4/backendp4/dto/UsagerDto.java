package com.backendp4.backendp4.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsagerDto {
    private Long id;
    @NotBlank

    private String prenom;
    @NotBlank

    private String nom;
    @NotBlank

    private String msisdn;
    @NotBlank

    private String numeroContact;
    @NotBlank

    private String login;
    @NotBlank

    private String password;
    @NotBlank

    private String geolatitude;
    @NotBlank

    private String geolongititude;

    @Override
    public String toString() {
        return "VtoDto{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", numeroContact='" + numeroContact + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", geolatitude='" + geolatitude + '\'' +
                ", geolongititude='" + geolongititude + '\'' +
                '}';
    }
}
