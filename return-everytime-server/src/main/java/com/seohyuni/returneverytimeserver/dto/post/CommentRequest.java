package com.seohyuni.returneverytimeserver.dto.post;

import com.seohyuni.returneverytimeserver.model.post.Comment;
import com.seohyuni.returneverytimeserver.model.post.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CommentRequest {

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

    public Comment toEntity(Post post, User user) {
      Comment entity = Comment.builder()
          .content(content)
          .post(post)
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

    @ApiModelProperty(value = "내용", required = true)
    private String content;

  }

}
