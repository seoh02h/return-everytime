package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.advice.exception.UnauthorizedException;
import com.seohyuni.returneverytimeserver.dto.user.UserRequest;
import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.user.Role;
import com.seohyuni.returneverytimeserver.security.details.UserDetailsImpl;
import com.seohyuni.returneverytimeserver.security.jwt.JwtUtils;
import com.seohyuni.returneverytimeserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@Api(value = "User", tags = {"User"})
@RequiredArgsConstructor
public class UserController {

  private final UserService service;


  private final AuthenticationManager authenticationManager;

  @ApiOperation("사용자 전체 조회")
  @GetMapping("/users")
  public List<UserResponse.Get> getAll() {
    return service.getAll();
  }

  @ApiOperation("회원가입")
  @PostMapping("/users")
  public UserResponse.Get registerUser(@RequestBody UserRequest.Save request) {
    return service.save(request);
  }

  @ApiOperation("로그인")
  @PostMapping("/users/login")
  public UserResponse.Login login(@RequestBody UserRequest.Login request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    String token = JwtUtils.generateJwt(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    if (request.getIsAdmin()) {
      if (!userDetails.getAuthorities().stream()
          .anyMatch(a -> a.getAuthority().equals(Role.ROLE_ADMIN.toString()))) {
        throw new UnauthorizedException();
      }
    } else {
      if (!userDetails.getAuthorities().stream()
          .anyMatch(a -> a.getAuthority().equals(Role.ROLE_USER.toString()))) {
        throw new UnauthorizedException();
      }
    }
    return UserResponse.Login.builder()
        .token(token)
        .id(userDetails.getId())
        .email(userDetails.getUsername())
        .build();
  }

  @ApiOperation("로그인 사용자 조회")
  @GetMapping("/users/logged-in")
  public UserResponse.Get getLoggedInUser() {
    return service.getLoggedInUser();
  }

  @ApiOperation("사용자 프로필 이미지 설정")
  @PostMapping("/users/{userId}/images")
  @SneakyThrows
  public UserResponse.Get saveImage(@PathVariable Long userId,
      @RequestPart MultipartFile ImageFile) {
    return service.saveImage(userId, ImageFile);

  }


}
