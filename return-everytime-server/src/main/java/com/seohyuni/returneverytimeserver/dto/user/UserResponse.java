package com.seohyuni.returneverytimeserver.dto.user;

import com.seohyuni.returneverytimeserver.model.user.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserResponse {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get{

    @ApiModelProperty(value = "사용자 식별번호",position = 0)
    private Long id;

    @ApiModelProperty(value = "이메일", position = 1)
    private String email;

    @ApiModelProperty(value = "이름", position = 2)
    private String name;

    @ApiModelProperty(value = "권한", position = 3)
    private Role role;
  }


  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save{

    @ApiModelProperty(value = "사용자 식별번호",position = 0)
    private Long id;

    @ApiModelProperty(value = "이메일", position = 1)
    private String email;

    @ApiModelProperty(value = "이름", position = 2)
    private String name;

    @ApiModelProperty(value = "권한", position = 3)
    private Role role;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Login{

    @ApiModelProperty(value = "사용자 식별번호",position = 0)
    private Long id;

    @ApiModelProperty(value = "이메일", position = 1)
    private String email;

    @ApiModelProperty(value = "토큰", position = 2)
    private String token;

  }

}
