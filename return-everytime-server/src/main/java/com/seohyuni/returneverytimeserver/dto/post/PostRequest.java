package com.seohyuni.returneverytimeserver.dto.post;

import com.seohyuni.returneverytimeserver.model.post.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PostRequest {

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

    public Post toEntity(User user) {
      Post entity = Post.builder()
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

    public Post toEntity() {
      Post entity = Post.builder()
          .title(title)
          .content(content)
          .build();
      return entity;

    }
  }

}
