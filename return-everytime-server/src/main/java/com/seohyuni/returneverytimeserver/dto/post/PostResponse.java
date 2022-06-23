package com.seohyuni.returneverytimeserver.dto.post;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.post.Post;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class PostResponse {

  private static ModelMapper modelMapper = new ModelMapper();

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "게시글 식별번호")
    private Long id;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시")
    private LocalDateTime ModifiedDate;

    public static PostResponse.Get toResponse(Post entity) {
      PostResponse.Get response = modelMapper.map(entity, PostResponse.Get.class);
      return response;
    }

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GetList {

    @ApiModelProperty(value = "게시글 식별번호")
    private Long id;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시")
    private LocalDateTime modifiedDate;

    public static PostResponse.GetList toResponse(Post post) {
      PostResponse.GetList response = modelMapper.map(post, PostResponse.GetList.class);
      return response;
    }

  }

}
