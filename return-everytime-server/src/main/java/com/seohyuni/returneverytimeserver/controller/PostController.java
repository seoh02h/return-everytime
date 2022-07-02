package com.seohyuni.returneverytimeserver.controller;

import com.seohyuni.returneverytimeserver.dto.notice.NoticeResponse;
import com.seohyuni.returneverytimeserver.dto.post.PostRequest;
import com.seohyuni.returneverytimeserver.dto.post.PostResponse;
import com.seohyuni.returneverytimeserver.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@Api(value = "Post", tags = {"Post"})
@RequiredArgsConstructor
public class PostController {

  private final PostService service;

  @ApiOperation("게시글 목록 조회")
  @GetMapping("/posts")
  public List<PostResponse.GetList> getList(@RequestParam(required = false) String title) {
    return service.getList(title).stream().map(PostResponse.GetList::of)
        .collect(Collectors.toList());
  }

  @ApiOperation("게시글 조회")
  @GetMapping("/posts/{postId}")
  public PostResponse.Get get(@PathVariable Long postId) {
    return service.get(postId);
  }

  @ApiOperation("게시글 생성")
  @PostMapping("/posts")
  public PostResponse.Get save(@RequestBody PostRequest.Save request) {
    return service.save(request);
  }

  @ApiOperation("게시글 수정")
  @PutMapping("/posts/{postId}")
  public PostResponse.Get save(@PathVariable Long postId,
      @RequestBody PostRequest.Update request) {
    return service.update(postId, request);
  }

  @ApiOperation("게시글 삭제")
  @DeleteMapping("/posts/{postId}")
  public void delete(@PathVariable Long postId) {
    service.delete(postId);
  }

  @ApiOperation("게시글 이미지 추가")
  @PostMapping("/posts/{postId}/images")
  @SneakyThrows
  public PostResponse.Get saveImage(@PathVariable Long postId,
      @RequestPart List<MultipartFile> imageList) {
    return PostResponse.Get.of(service.saveImage(postId, imageList));

  }
}
