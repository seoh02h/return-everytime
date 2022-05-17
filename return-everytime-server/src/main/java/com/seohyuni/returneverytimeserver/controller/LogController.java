package com.seohyuni.returneverytimeserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Log", tags = {"Log"})
@RequiredArgsConstructor
public class LogController {

  @ApiOperation("시스템 로그 조회")
  @GetMapping("/log")
  public String get() {
    return "log";
  }

}
