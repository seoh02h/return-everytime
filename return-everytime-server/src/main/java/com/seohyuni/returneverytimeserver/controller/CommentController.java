package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.board.CommentRequest;
import com.seohyuni.returneverytimeserver.dto.board.CommentResponse;
import com.seohyuni.returneverytimeserver.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Comment", tags = {"Comment"})
@RequiredArgsConstructor
public class CommentController {

  private final CommentService service;

  @ApiOperation("댓글 목록 조회")
  @GetMapping("/comments/{boardId}")
  public List<CommentResponse.GetList> getList(@PathVariable Long boardId) {
    return service.getList(boardId);
  }

  @ApiOperation("댓글 생성")
  @PostMapping("/comments")
  public CommentResponse.Save save(@RequestBody CommentRequest.Save request) {
    return service.save(request);
  }

}
