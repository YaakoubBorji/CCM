package com.yaakoub.cryptocurrencymarket.model;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Position
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@Entity
@Table(name = "position")
@Data
public class Position  implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_position")
  @JsonProperty("positionId")
  private Long id = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("amount")
  private Long amount = null;

  @JsonProperty("user")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_user")
  private User user;

  /**
   * currency Status
   */
  public enum StatusEnum {
    OPEN("open"),
    
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public static Position positionFactory(){
    return new Position();
  }

}

