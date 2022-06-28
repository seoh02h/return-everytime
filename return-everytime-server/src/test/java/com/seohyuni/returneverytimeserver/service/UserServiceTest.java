package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Spy
  private BCryptPasswordEncoder passwordEncoder;

  @Test
  @DisplayName("사용자 회원가입")
  void 사용자회원가입() {
//    // given
//    UserRequest.Save request = UserRequest.Save.builder()
//        .email("seohyun@gmail.com")
//        .password("pw")
//        .name("서현")
//        .phone("01011111111")
//        .build();
//
//    // when
//    UserResponse.Get response = userService.save(request);
//
//    // then
//    Assertions.assertEquals(request.getEmail(), response.getEmail());

  }

}
