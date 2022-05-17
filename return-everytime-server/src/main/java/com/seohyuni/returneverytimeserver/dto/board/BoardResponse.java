package com.seohyuni.returneverytimeserver.dto.board;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardResponse {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "게시판 식별번호", position = 0)
    private Long id;

    @ApiModelProperty(value = "이름", position = 1)
    private String name;

    @ApiModelProperty(value = "생성일시", position = 2)
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시", position = 3)
    private LocalDateTime modifiedDate;
  }

}
