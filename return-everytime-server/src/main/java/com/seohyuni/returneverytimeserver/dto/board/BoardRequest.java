package com.seohyuni.returneverytimeserver.dto.board;

import com.seohyuni.returneverytimeserver.model.board.Board;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class BoardRequest {

  private static ModelMapper modelMapper = new ModelMapper();

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save {

    @ApiModelProperty(value = "이름", required = true)
    private String name;

    @ApiModelProperty(value = "작성자")
    private Long userId;

    @ApiModelProperty(value = "설명")
    private String description;

    @ApiModelProperty(value = "삭제가능여부")
    private boolean canDel;

    public Board toEntity(User user) {
      Board entity = modelMapper.map(this, Board.class);
      entity.setUser(user);
      return entity;
    }
  }

}
