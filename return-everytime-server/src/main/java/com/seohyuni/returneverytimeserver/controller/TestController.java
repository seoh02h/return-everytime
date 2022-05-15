package com.seohyuni.returneverytimeserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Test", tags = {"Test"})
@RequiredArgsConstructor
public class TestController {

  @ApiOperation("커넥션 테스트")
  @GetMapping("/test")
  public String test() {
    return "test";
  }

}
