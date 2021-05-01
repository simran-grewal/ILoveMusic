package com.BuyMusicInstruments.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    //One Country Have Many States

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    //It will ignore the states while returning countries
    private List<State> states;
}
