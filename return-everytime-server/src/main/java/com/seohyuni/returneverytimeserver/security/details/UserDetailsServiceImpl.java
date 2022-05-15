package com.seohyuni.returneverytimeserver.security.details;

import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = repository.findByEmail(username);
    if(!optionalUser.isPresent()){
      throw new UsernameNotFoundException("가입되지 않은 이메일입니다.");
    }
    User user = optionalUser.get();
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), this.getAuthority(user.getRole().toString()));
  }

  private Collection<? extends GrantedAuthority> getAuthority(String role){
    return Arrays.asList(new SimpleGrantedAuthority(role));
  }
}
