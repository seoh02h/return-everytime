package com.seohyuni.returneverytimeserver.dto.user;

import com.seohyuni.returneverytimeserver.model.user.Role;
import com.seohyuni.returneverytimeserver.model.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class UserResponse {

  private static ModelMapper modelMapper = new ModelMapper();

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "사용자 식별번호", position = 0)
    private Long id;

    @ApiModelProperty(value = "이메일", position = 1)
    private String email;

    @ApiModelProperty(value = "이름", position = 2)
    private String name;

    @ApiModelProperty(value = "권한", position = 3)
    private Role role;

    @ApiModelProperty(value = "프로필이미지", position = 4)
    private String imageUrl;

    public static UserResponse.Get toResponse(User entity) {
      UserResponse.Get response = modelMapper.map(entity, UserResponse.Get.class);
      return response;
    }
  }


  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Save{

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

    public static UserResponse.Save toResponse(User entity) {
      UserResponse.Save response = modelMapper.map(entity, UserResponse.Save.class);
      return response;
    }
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Login{

    @ApiModelProperty(value = "사용자 식별번호")
    private Long id;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "토큰")
    private String token;

  }

}
