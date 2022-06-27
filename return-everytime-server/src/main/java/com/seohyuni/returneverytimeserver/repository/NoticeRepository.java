package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
