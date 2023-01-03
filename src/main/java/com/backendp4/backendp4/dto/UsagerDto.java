package com.backendp4.backendp4.dto;

import lombok.Data;

@Data
public class UsagerDto {
    private Long id;
    private String prenom;
    private String nom;
    private String msisdn;
    private String numeroContact;
    private String login;
    private String password;
    private String geolatitude;
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
