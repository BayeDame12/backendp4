package com.backendp4.backendp4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String role;
    @Column
    private String prenom;
    @Column
    private String nom;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
           // fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Vto>vtos= new ArrayList<>();
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
           // fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Vpt>vpts= new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", vtos=" + vtos +
                ", vpts=" + vpts +
                '}';
    }
}
