package com.seohyuni.returneverytimeserver.dto.post;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.post.Comment;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CommentResponse {


  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GetList {

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시")
    private LocalDateTime modifiedDate;

    @ApiModelProperty(value = "수정가능여부")
    private Boolean editable;

    public static CommentResponse.GetList of(Comment entity) {
      CommentResponse.GetList response = GetList.builder()
          .content(entity.getContent())
          .user(UserResponse.Get.of(entity.getUser()))
          .createdDate(entity.getCreatedDate())
          .modifiedDate(entity.getModifiedDate())
          .editable(entity.isEditable())
          .build();

      return response;
    }

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시")
    private LocalDateTime modifiedDate;

    @ApiModelProperty(value = "수정가능여부")
    private Boolean editable;

    public static CommentResponse.Get of(Comment entity) {
      CommentResponse.Get response = Get.builder()
          .content(entity.getContent())
          .user(UserResponse.Get.of(entity.getUser()))
          .createdDate(entity.getCreatedDate())
          .modifiedDate(entity.getModifiedDate())
          .editable(entity.isEditable())
          .build();
      return response;
    }

  }


}
