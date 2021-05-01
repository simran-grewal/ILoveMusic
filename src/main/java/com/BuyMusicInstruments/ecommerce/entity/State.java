package com.BuyMusicInstruments.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="state")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    //Many states have one country
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
}
