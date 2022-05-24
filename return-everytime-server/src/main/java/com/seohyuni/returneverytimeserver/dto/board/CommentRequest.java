package com.seohyuni.returneverytimeserver.dto.board;

import com.seohyuni.returneverytimeserver.model.board.Comment;
import com.seohyuni.returneverytimeserver.model.board.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class CommentRequest {

  private static ModelMapper modelMapper = new ModelMapper();

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save {

    @ApiModelProperty(value = "내용", required = true)
    private String content;

    @ApiModelProperty(value = "작성자", required = true)
    private Long userId;

    @ApiModelProperty(value = "게시글", required = true)
    private Long postId;

    @ApiModelProperty(value = "상위댓글", required = false)
    private Long commentId;

    public Comment toEntity(Post post, User user) {
      Comment entity = modelMapper.map(this, Comment.class);
      entity.setUser(user);
      entity.setPost(post);
      return entity;
    }

  }

}
