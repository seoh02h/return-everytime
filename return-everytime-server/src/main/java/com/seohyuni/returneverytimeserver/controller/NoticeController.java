package com.seohyuni.returneverytimeserver.controller;


import com.seohyuni.returneverytimeserver.dto.notice.NoticeRequest;
import com.seohyuni.returneverytimeserver.dto.notice.NoticeResponse;
import com.seohyuni.returneverytimeserver.service.NoticeService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Notice", tags = {"Notice"})
@RequiredArgsConstructor
public class NoticeController {

  private final NoticeService service;

  @ApiOperation("공지사항 목록 조회")
  @GetMapping("/notices")
  public List<NoticeResponse.GetList> getList() {
    return service.getList();
  }

  @ApiOperation("공지사항 조회")
  @GetMapping("/notices/{noticeId}")
  public NoticeResponse.Get get(@PathVariable Long noticeId) {
    return service.get(noticeId);
  }

  @ApiOperation("공지사항 생성")
  @PostMapping("/notices")
  public NoticeResponse.Get save(@RequestBody NoticeRequest.Save request) {
    return service.save(request);
  }

  @ApiOperation("공지사항 수정")
  @PutMapping("/notices/{noticeId}")
  public NoticeResponse.Get update(@PathVariable Long noticeId,
      @RequestBody NoticeRequest.Update request) {
    return service.update(noticeId, request);
  }

  @ApiOperation("공지사항 삭제")
  @DeleteMapping("/notices/{noticeId}")
  public void delete(@PathVariable Long noticeId) {
    service.delete(noticeId);
  }

}
