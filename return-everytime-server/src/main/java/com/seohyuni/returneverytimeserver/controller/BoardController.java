package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.board.BoardRequest;
import com.seohyuni.returneverytimeserver.dto.board.BoardResponse;
import com.seohyuni.returneverytimeserver.model.board.Board;
import com.seohyuni.returneverytimeserver.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

  private final ModelMapper modelMapper;

  @ApiOperation("게시판 목록 조회")
  @GetMapping("/board")
  public List<BoardResponse.Get> getAll() {
    return service.getAll().stream().map(x -> modelMapper.map(x, BoardResponse.Get.class)).collect(
        Collectors.toList());
  }

  @ApiOperation("게시판 생성")
  @PostMapping("/board")
  public BoardResponse.Get save(@RequestBody BoardRequest.Get request) {
    return modelMapper.map(service.save(modelMapper.map(request, Board.class)),
        BoardResponse.Get.class);
  }

}
