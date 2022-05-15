package com.seohyuni.returneverytimeserver.dto.user;

import com.seohyuni.returneverytimeserver.model.user.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserRequest {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save{

    @ApiModelProperty(value = "이메일", required = true, position = 0)
    private String email;

    @ApiModelProperty(value = "비밀번호", required = true, position = 1)
    private String password;

    @ApiModelProperty(value = "이름", required = true, position = 2)
    private String name;

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Login{

    @ApiModelProperty(value = "이메일", required = true, position = 0)
    private String email;

    @ApiModelProperty(value = "비밀번호", required = true, position = 1)
    private String password;

    @ApiModelProperty(value = "권한", required = true, position = 2)
    private Role role;

  }

}
