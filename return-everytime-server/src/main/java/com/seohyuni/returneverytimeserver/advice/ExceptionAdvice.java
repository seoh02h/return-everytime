package com.seohyuni.returneverytimeserver.advice;

import com.seohyuni.returneverytimeserver.advice.exception.UnauthorizedException;
import com.seohyuni.returneverytimeserver.dto.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ErrorResponse.Simple unauthorizedException(UnauthorizedException e) {
    return ErrorResponse.Simple.builder().message("unauthorized").build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse.Simple runtimeException(RuntimeException e) {
    return ErrorResponse.Simple.builder().message(e.getMessage()).build();
  }
}
