package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.user.UserRequest;
import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.user.Role;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import com.seohyuni.returneverytimeserver.utils.FileUtils;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  private final PasswordEncoder passwordEncoder;

  @Transactional(readOnly = true)
  public List<User> getList() {
    return repository.findAll();
  }

  @Transactional(readOnly = true)
  public User get(Long userId){
    return repository.getById(userId);
  }

  @Transactional
  public UserResponse.Get save(UserRequest.Save request) {
    repository.findByEmail(request.getEmail()).ifPresent(x -> {
      throw new RuntimeException("중복된 이메일이 존재합니다.");
    });

    User user = request.toEntity();

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(Role.ROLE_USER);

    return UserResponse.Get.of(repository.save(user));
  }

  @Transactional(readOnly = true)
  public UserResponse.Get getLoggedInUser() {

    SecurityContext securityContext = SecurityContextHolder.getContext();
    if (securityContext.getAuthentication().getClass().equals(AnonymousAuthenticationToken.class)) {
      // TODO Exception
      return null;
    }

    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();

    return UserResponse.Get.of(repository.findByEmail(userDetails.getUsername()).get());
  }

  @Transactional
  @SneakyThrows
  public UserResponse.Get saveImage(Long userId, MultipartFile imageFile) {

    User user = repository.getById(userId);
    String imageUrl = FileUtils.saveImage(imageFile);
    user.setImageUrl(imageUrl);

    return UserResponse.Get.of(user);
  }


}
