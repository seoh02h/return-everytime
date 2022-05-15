package com.seohyuni.returneverytimeserver.security.jwt;

import com.seohyuni.returneverytimeserver.security.details.UserDetailsImpl;
import com.seohyuni.returneverytimeserver.security.details.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtUtils jwtUtils;

  private final UserDetailsServiceImpl userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String token = jwtUtils.parseJwtFromHeader(request);
    if(token != null && jwtUtils.validateJwt(token)){
      String username = jwtUtils.getUsernameFromJwt(token);

      UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
          userDetails, null, userDetails.getAuthorities()
      );

      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
    filterChain.doFilter(request, response);
  }

}
