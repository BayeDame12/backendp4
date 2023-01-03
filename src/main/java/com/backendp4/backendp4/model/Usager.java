package com.backendp4.backendp4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usager")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String prenom;
    @Column
    private String nom;
    @Column(unique = true)
    private String msisdn;
    @Column(unique = true)
    private String numeroContact;
    @Column(unique = true)
    private String login;
    @Column
    private String password;
    @Column
    private String geolatitude;
    @Column
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
