package com.yaakoub.cryptocurrencymarket.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Role
 */

public enum RoleEnum {
  
  ADMINISTRATOR("ADMINISTRATOR"),
  
  USER("USER");

  private String value;

  RoleEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RoleEnum fromValue(String text) {
    for (RoleEnum b : RoleEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

