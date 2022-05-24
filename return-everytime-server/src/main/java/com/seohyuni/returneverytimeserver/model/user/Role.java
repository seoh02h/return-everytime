package com.seohyuni.returneverytimeserver.model.user;

import lombok.Getter;

@Getter
public enum Role {
  ROLE_ADMIN("admin"),
  ROLE_USER("user");

  private String description;

  Role(String description) {
    this.description = description;
  }
}
