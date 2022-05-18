package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.board.BoardRequest;
import com.seohyuni.returneverytimeserver.dto.board.BoardResponse;
import com.seohyuni.returneverytimeserver.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Board", tags = {"Board"})
@RequiredArgsConstructor
public class BoardController {

  private final BoardService service;

  @ApiOperation("게시판 목록 조회")
  @GetMapping("/boards")
  public List<BoardResponse.GetList> getAll() {
    return service.getAll();
  }

  @ApiOperation("게시판 생성")
  @PostMapping("/boards")
  public BoardResponse.Save save(@RequestBody BoardRequest.Save request) {
    return service.save(request);
  }



}
