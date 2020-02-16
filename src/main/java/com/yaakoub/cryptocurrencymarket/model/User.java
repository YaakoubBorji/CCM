package com.yaakoub.cryptocurrencymarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@Entity
@Table(name="user_currency")
@Data
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("idUser")
  @Column(name = "id_user")
  private Long id = null;

  @JsonProperty("username")
  @Column(name = "user_name",unique = true)
  private String username = null;

  @JsonProperty("firstName")
  @Column(name = "first_name")
  private String firstName = null;

  @JsonProperty("familyName")
  @Column(name = "family_name")
  private String familyName = null;

  @JsonProperty("role")
  @Enumerated(EnumType.STRING)
  private RoleEnum role = null;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }
}

