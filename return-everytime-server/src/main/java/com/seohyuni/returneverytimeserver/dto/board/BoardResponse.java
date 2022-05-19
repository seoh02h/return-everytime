package com.seohyuni.returneverytimeserver.dto.board;

import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.board.Board;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class BoardResponse {

  private static ModelMapper modelMapper = new ModelMapper();

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "게시판 식별번호", position = 0)
    private Long id;

    @ApiModelProperty(value = "이름", position = 1)
    private String name;

    @ApiModelProperty(value = "작성자", position = 2)
    private UserResponse.Get user;

    public static BoardResponse.Get toResponse(Board entity) {
      BoardResponse.Get response = modelMapper.map(entity, BoardResponse.Get.class);
      return response;
    }

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GetList {

    @ApiModelProperty(value = "게시판 식별번호", position = 0)
    private Long id;

    @ApiModelProperty(value = "이름", position = 1)
    private String name;

    @ApiModelProperty(value = "작성자", position = 2)
    private UserResponse.Get user;

    public static BoardResponse.GetList toResponse(Board entity) {
      BoardResponse.GetList response = modelMapper.map(entity, BoardResponse.GetList.class);
      return response;
    }
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save {

    @ApiModelProperty(value = "게시판 식별번호", position = 0)
    private Long id;

    @ApiModelProperty(value = "이름", position = 1)
    private String name;

    @ApiModelProperty(value = "생성일시", position = 2)
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시", position = 3)
    private LocalDateTime modifiedDate;

    public static BoardResponse.Save toResponse(Board entity) {
      BoardResponse.Save response = modelMapper.map(entity, BoardResponse.Save.class);
      return response;
    }
  }

}
