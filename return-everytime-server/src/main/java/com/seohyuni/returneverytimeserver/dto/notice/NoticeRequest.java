package com.seohyuni.returneverytimeserver.dto.notice;

import com.seohyuni.returneverytimeserver.model.notice.Notice;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NoticeRequest {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save {

    @ApiModelProperty(value = "제목", required = true)
    private String title;

    @ApiModelProperty(value = "내용", required = true)
    private String content;

    @ApiModelProperty(value = "작성자", required = true)
    private Long userId;

    public Notice toEntity(User user) {
      Notice entity = Notice.builder()
          .title(title)
          .content(content)
          .user(user)
          .build();
      return entity;
    }
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Update {

    @ApiModelProperty(value = "제목", required = true)
    private String title;

    @ApiModelProperty(value = "내용", required = true)
    private String content;

    public Notice toEntity(User user) {
      Notice entity = Notice.builder()
          .title(title)
          .content(content)
          .build();
      return entity;
    }
  }
}
