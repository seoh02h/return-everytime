package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.model.user.Role;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import com.seohyuni.returneverytimeserver.security.details.UserDetailsImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  private final PasswordEncoder passwordEncoder;

  @Transactional
  public List<User> getAll(){
    return repository.findAll();
  }

  @Transactional
  public User save(User user){
    repository.findByEmail(user.getEmail()).ifPresent(x ->{
      throw new IllegalStateException("중복된 이메일이 존재합니다.");
    });

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(Role.ROLE_USER);

    return repository.save(user);
  }

  @Transactional(readOnly = true)
  public User getLoggedInUser(){

    if(SecurityContextHolder.getContext() == null){
      return null;
    }

    UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = repository.findById(userDetails.getId()).get();
    return user;


  }



}
