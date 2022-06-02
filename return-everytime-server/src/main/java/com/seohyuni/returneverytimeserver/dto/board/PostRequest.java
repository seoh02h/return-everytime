package com.seohyuni.returneverytimeserver.dto.board;

import com.seohyuni.returneverytimeserver.model.board.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class PostRequest {

  private static ModelMapper modelMapper = new ModelMapper();

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

    @ApiModelProperty(value = "게시판", required = true)
    private Long boardId;

    public Post toEntity(User user) {
      Post entity = modelMapper.map(this, Post.class);
      entity.setUser(user);
      return entity;
    }
  }

}
