package com.yaakoub.cryptocurrencymarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Role {

    @Id
    @JsonProperty("roleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @JsonProperty("roleName")
    @Column(name = "role_name")
    private String name;

}
