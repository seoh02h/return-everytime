package com.seohyuni.returneverytimeserver.dto.board;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.board.Post;
import io.swagger.annotations.ApiModelProperty;
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

    public static PostResponse.GetList toResponse(Post entity) {
      PostResponse.GetList response = modelMapper.map(entity, PostResponse.GetList.class);
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

    public static PostResponse.GetList toResponse(Post post) {
      PostResponse.GetList response = modelMapper.map(post, PostResponse.GetList.class);
      return response;
    }

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save {

    @ApiModelProperty(value = "게시글 식별번호")
    private Long id;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    public static PostResponse.Save toResponse(Post post) {
      PostResponse.Save response = modelMapper.map(post, PostResponse.Save.class);
      return response;
    }

  }
}
