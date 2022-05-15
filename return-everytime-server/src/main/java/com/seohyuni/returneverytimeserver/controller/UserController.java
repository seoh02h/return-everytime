package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.user.UserRequest;
import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.security.details.UserDetailsImpl;
import com.seohyuni.returneverytimeserver.security.jwt.JwtUtils;
import com.seohyuni.returneverytimeserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "User", tags = {"User"})
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  private final ModelMapper modelMapper;

  private final AuthenticationManager authenticationManager;

  private final JwtUtils jwtUtils;

  @ApiOperation("사용자 전체 조회")
  @GetMapping("/users")
  public List<User> getAll() {
    return service.getAll();
  }

  @ApiOperation("회원가입")
  @PostMapping("/users")
  public UserResponse.Save registerUser(@RequestBody UserRequest.Save request) {
    User user = modelMapper.map(request, User.class);
    return modelMapper.map(service.save(user), UserResponse.Save.class);
  }

  @ApiOperation("로그인")
  @PostMapping("/users/login")
  public UserResponse.Login login(@RequestBody UserRequest.Login request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtUtils.generateJwt(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    return UserResponse.Login.builder()
        .token(token)
        .id(userDetails.getId())
        .email(userDetails.getUsername())
        .build();
  }

  @ApiOperation("로그인 사용자 조회")
  @GetMapping("/users/logged-in")
  public UserResponse.Get getLoggedInUser(){
    return modelMapper.map(service.getLoggedInUser(), UserResponse.Get.class);
  }



}
