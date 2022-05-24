package com.seohyuni.returneverytimeserver.model.board;

import lombok.Getter;

@Getter
public enum Category {

  NOTICE("notice"),
  BASIC("basic"),
  STUDY("study");


  private String description;

  Category(String description) {
    this.description = description;
  }

}
