package com.seohyuni.returneverytimeserver.dto.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardRequest {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "이름", required = true, position = 0)
    private String name;

    @ApiModelProperty(value = "작성자", position = 1)
    private Long userId;

    @ApiModelProperty(value = "설명", position = 1)
    private String description;

  }

}
