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
public class Vto  extends Usager{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vpt_id")
    private Vpt vpt;
    
}
