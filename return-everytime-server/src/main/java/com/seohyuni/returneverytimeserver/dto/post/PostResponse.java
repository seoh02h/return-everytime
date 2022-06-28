package com.seohyuni.returneverytimeserver.dto.post;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.post.Post;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PostResponse {

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
    private LocalDateTime modifiedDate;

    @ApiModelProperty(value = "수정가능여부")
    private Boolean editable;

    @ApiModelProperty(value = "댓글개수")
    private int numOfComments;

    @ApiModelProperty(value = "댓글")
    private List<CommentResponse.GetList> commentList;

    public static PostResponse.Get of(Post entity) {
      PostResponse.Get response = Get.builder()
          .id(entity.getId())
          .title(entity.getTitle())
          .content(entity.getContent())
          .user(UserResponse.Get.of(entity.getUser()))
          .createdDate(entity.getCreatedDate())
          .modifiedDate(entity.getModifiedDate())
          .editable(entity.isEditable())
          .numOfComments(entity.getNumOfComments())
          .commentList(entity.getCommentList().stream().map(CommentResponse.GetList::of).collect(
              Collectors.toList()))
          .build();

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

    @ApiModelProperty(value = "댓글개수")
    private int numOfComments;

    public static PostResponse.GetList of(Post entity) {
      PostResponse.GetList response = GetList.builder()
          .id(entity.getId())
          .title(entity.getTitle())
          .content(entity.getContent())
          .user(UserResponse.Get.of(entity.getUser()))
          .createdDate(entity.getCreatedDate())
          .modifiedDate(entity.getModifiedDate())
          .numOfComments(entity.getNumOfComments())
          .build();
      return response;
    }

  }

}
