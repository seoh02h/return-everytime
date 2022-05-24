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

    @ApiModelProperty(value = "생성자", required = true)
    private Long userId;

    @ApiModelProperty(value = "설명", required = true)
    private String description;

    @ApiModelProperty(value = "일반사용자 작성 가능여부", required = true)
    private boolean writable;

    public Board toEntity(User user) {
      Board entity = modelMapper.map(this, Board.class);
      entity.setUser(user);
      return entity;
    }
  }

}
