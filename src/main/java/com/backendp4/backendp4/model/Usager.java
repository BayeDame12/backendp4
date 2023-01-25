package com.backendp4.backendp4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
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
    private String geolatitude;
    @Column
    private String geolongititude;
    @Column
    private String type;

    @Override
    public String toString() {
        return "Usager{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", numeroContact='" + numeroContact + '\'' +
                ", login='" + login + '\'' +
                ", geolatitude='" + geolatitude + '\'' +
                ", geolongititude='" + geolongititude + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
