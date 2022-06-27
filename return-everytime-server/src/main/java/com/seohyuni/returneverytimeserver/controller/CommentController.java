package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.post.CommentRequest;
import com.seohyuni.returneverytimeserver.dto.post.CommentResponse;
import com.seohyuni.returneverytimeserver.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Comment", tags = {"Comment"})
@RequiredArgsConstructor
public class CommentController {

  private final CommentService service;

  @ApiOperation("댓글 목록 조회")
  @GetMapping("/comments")
  public List<CommentResponse.GetList> getList(@RequestParam Long postId) {
    return service.getList(postId);
  }

  @ApiOperation("댓글 조회")
  @GetMapping("/comments/{commentId}")
  public CommentResponse.Get get(@PathVariable Long commentId) {
    return service.get(commentId);
  }

  @ApiOperation("댓글 생성")
  @PostMapping("/comments")
  public CommentResponse.Get save(@RequestBody CommentRequest.Save request) {
    return service.save(request);
  }

  @ApiOperation("댓글 수정")
  @PutMapping("/comments/{commentId}")
  public CommentResponse.Get update(@PathVariable Long commentId,
      @RequestBody CommentRequest.Update request) {
    return service.update(commentId, request);
  }

  @ApiOperation("댓글 삭제")
  @DeleteMapping("/comments/{commentId}")
  public void delete(@PathVariable Long commentId) {
    service.delete(commentId);
  }

}
