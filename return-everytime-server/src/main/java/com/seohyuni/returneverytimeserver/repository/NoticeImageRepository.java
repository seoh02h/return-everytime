package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.notice.NoticeImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeImageRepository extends JpaRepository<NoticeImage, Long> {

  void deleteByNoticeId(Long noticeId);

  List<NoticeImage> findByNoticeId(Long noticeId);
}
