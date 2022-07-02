package com.seohyuni.returneverytimeserver.dto.common;

import com.seohyuni.returneverytimeserver.dto.notice.NoticeResponse;
import com.seohyuni.returneverytimeserver.model.notice.Notice;
import com.seohyuni.returneverytimeserver.model.notice.NoticeImage;
import com.seohyuni.returneverytimeserver.model.post.PostImage;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ImageResponse {

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Get {

    @ApiModelProperty(value = "주소")
    private String url;

    @ApiModelProperty(value = "원본이름")
    private String oriName;

    public static ImageResponse.Get of(NoticeImage noticeImage) {
      return Get.builder()
          .url(noticeImage.getImage().getUrl())
          .oriName(noticeImage.getImage().getOriName())
          .build();
    }

    public static ImageResponse.Get of(PostImage postImage) {
      return Get.builder()
          .url(postImage.getImage().getUrl())
          .oriName(postImage.getImage().getOriName())
          .build();
    }

  }

}
