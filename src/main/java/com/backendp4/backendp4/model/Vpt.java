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
public class Vpt extends Usager{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(
            mappedBy = "vpt",
            cascade = CascadeType.ALL,
           // fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Vto>vtos=new ArrayList<>();

}
