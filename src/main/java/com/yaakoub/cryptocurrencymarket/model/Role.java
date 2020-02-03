package com.yaakoub.cryptocurrencymarket.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;
    @Column(name = "role_name")
    private String name;

}
