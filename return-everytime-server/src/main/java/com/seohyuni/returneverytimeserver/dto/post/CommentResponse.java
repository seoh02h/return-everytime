package com.seohyuni.returneverytimeserver.dto.post;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.post.Comment;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class CommentResponse {

  private static ModelMapper modelMapper = new ModelMapper();

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

    public static CommentResponse.GetList toResponse(Comment entity) {
      CommentResponse.GetList response = modelMapper.map(entity, CommentResponse.GetList.class);
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

    public static CommentResponse.Get toResponse(Comment entity) {
      CommentResponse.Get response = modelMapper.map(entity, CommentResponse.Get.class);
      return response;
    }

  }


}
