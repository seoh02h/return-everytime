package com.seohyuni.returneverytimeserver.dto.board;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.board.Comment;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
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

    @ApiModelProperty(value = "하위댓글")
    private List<CommentResponse.GetList> commentList;

    public static CommentResponse.GetList toResponse(Comment entity){
      CommentResponse.GetList response = modelMapper.map(entity, CommentResponse.GetList.class );
      return response;
    }

  }
  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save {

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @ApiModelProperty(value = "상위댓글")
    private Long commentId;

    public static CommentResponse.Save toResponse(Comment entity){
      CommentResponse.Save response = modelMapper.map(entity, CommentResponse.Save.class );
      return response;
    }

  }


}
