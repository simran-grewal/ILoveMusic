package com.BuyMusicInstruments.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="state")
    private String state;

    @Column(name="street")
    private String street;

    @Column(name="zip_code")
    private String zipCode;

    //By Default keys have same name
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
