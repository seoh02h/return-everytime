package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.notice.NoticeRequest;
import com.seohyuni.returneverytimeserver.dto.notice.NoticeResponse;
import com.seohyuni.returneverytimeserver.model.notice.Notice;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.NoticeRepository;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository repository;

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public List<Notice> getList() {
    return repository.findAll(Sort.by(Direction.DESC, "createdDate"));
  }

  @Transactional(readOnly = true)
  public NoticeResponse.Get get(Long noticeId) {
    return NoticeResponse.Get.of(repository.getById(noticeId));
  }

  public NoticeResponse.Get save(NoticeRequest.Save request) {
    User user = userRepository.getById(request.getUserId());
    Notice notice = request.toEntity(user);

    return NoticeResponse.Get.of(repository.save(notice));
  }

  public NoticeResponse.Get update(Long noticeId, NoticeRequest.Update request) {
    Notice notice = repository.getById(noticeId);

    // update
    notice.setTitle(request.getTitle());
    notice.setContent(request.getContent());

    return NoticeResponse.Get.of(notice);

  }

  public void delete(Long noticeId) {
    repository.deleteById(noticeId);
  }
}
