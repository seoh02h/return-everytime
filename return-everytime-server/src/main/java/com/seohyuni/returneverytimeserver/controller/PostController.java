package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.board.PostRequest;
import com.seohyuni.returneverytimeserver.dto.board.PostResponse;
import com.seohyuni.returneverytimeserver.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Post", tags = {"Post"})
@RequiredArgsConstructor
public class PostController {

  private final PostService service;

  @ApiOperation("게시글 목록 조회")
  @GetMapping("/posts")
  public List<PostResponse.GetList> getList(@RequestParam Long boardId,
      @RequestParam(required = false) String title) {
    return service.getAll(boardId, title);
  }

  @ApiOperation("게시글 조회")
  @GetMapping("/posts/{postId}")
  public PostResponse.Get get(@PathVariable Long postId){
    return null;
  }

  @ApiOperation("게시글 생성")
  @PostMapping("/post")
  public PostResponse.Save save(@RequestBody PostRequest.Save request){
    return service.save(request);
  }

}
