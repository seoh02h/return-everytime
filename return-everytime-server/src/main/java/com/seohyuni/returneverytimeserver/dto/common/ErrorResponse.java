package com.seohyuni.returneverytimeserver.dto.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ErrorResponse {


  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Simple {

    @ApiModelProperty(value = "메시지")
    private String message;

  }

}
