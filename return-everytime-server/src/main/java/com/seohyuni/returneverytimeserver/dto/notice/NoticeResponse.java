package com.seohyuni.returneverytimeserver.dto.notice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seohyuni.returneverytimeserver.dto.common.ImageResponse;
import com.seohyuni.returneverytimeserver.dto.user.UserResponse;
import com.seohyuni.returneverytimeserver.model.notice.Notice;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

public class NoticeResponse {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "공지사항 식별번호")
    private Long id;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시")
    private LocalDateTime modifiedDate;

    @ApiModelProperty(value = "수정가능여부")
    private Boolean editable;

    @ApiModelProperty(value = "이미지")
    private List<ImageResponse.Get> imageList;

    public static NoticeResponse.Get of(Notice entity) {
      NoticeResponse.Get response = Get.builder()
          .id(entity.getId())
          .title(entity.getTitle())
          .content(entity.getContent())
          .user(UserResponse.Get.of(entity.getUser()))
          .createdDate(entity.getCreatedDate())
          .modifiedDate(entity.getModifiedDate())
          .editable(entity.isEditable())
          .imageList(entity.getNoticeImageList().stream().map(ImageResponse.Get::of).collect(
              Collectors.toList()))
          .build();
      return response;
    }

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GetList {

    @ApiModelProperty(value = "공지사항 식별번호")
    private Long id;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성자")
    private UserResponse.Get user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일시")
    private LocalDateTime modifiedDate;

    @ApiModelProperty(value = "이미지")
    private List<ImageResponse.Get> imageList;


    public static NoticeResponse.GetList of(Notice entity) {
      NoticeResponse.GetList response = GetList.builder()
          .id(entity.getId())
          .title(entity.getTitle())
          .content(entity.getContent())
          .user(UserResponse.Get.of(entity.getUser()))
          .createdDate(entity.getCreatedDate())
          .modifiedDate(entity.getModifiedDate())
          .imageList(entity.getNoticeImageList().stream().map(ImageResponse.Get::of).collect(
              Collectors.toList()))
          .build();
      return response;
    }

  }

}
