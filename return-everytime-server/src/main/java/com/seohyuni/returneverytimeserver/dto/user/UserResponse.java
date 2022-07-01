package com.seohyuni.returneverytimeserver.dto.user;

import com.seohyuni.returneverytimeserver.model.user.Role;
import com.seohyuni.returneverytimeserver.model.user.User;
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
  public static class Get {

    @ApiModelProperty(value = "사용자 식별번호")
    private Long id;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "이름")
    private String name;

    @ApiModelProperty(value = "권한")
    private Role role;

    @ApiModelProperty(value = "휴대폰번호")
    private String phone;

    @ApiModelProperty(value = "프로필이미지")
    private String imageUrl;

    public static UserResponse.Get of(User entity) {
      UserResponse.Get response = Get.builder()
          .id(entity.getId())
          .email(entity.getEmail())
          .name(entity.getName())
          .role(entity.getRole())
          .phone(entity.getPhone())
          .imageUrl(entity.getImageUrl())
          .build();

      return response;
    }
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Login {

    @ApiModelProperty(value = "사용자 식별번호")
    private Long id;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "이름")
    private String name;

    @ApiModelProperty(value = "권한")
    private Boolean isAdmin;

    @ApiModelProperty(value = "토큰")
    private String token;

    @ApiModelProperty(value = "휴대폰번호")
    private String phone;

    @ApiModelProperty(value = "프로필이미지")
    private String imageUrl;

    public static UserResponse.Login of(User entity, String token) {
      UserResponse.Login response = Login.builder()
          .id(entity.getId())
          .email(entity.getEmail())
          .name(entity.getName())
          .phone(entity.getPhone())
          .imageUrl(entity.getImageUrl())
          .isAdmin(entity.isAdmin())
          .token(token)
          .build();

      return response;
    }

  }

}
