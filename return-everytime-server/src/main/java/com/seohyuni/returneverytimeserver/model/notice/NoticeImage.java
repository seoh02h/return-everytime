package com.seohyuni.returneverytimeserver.model.notice;

import com.seohyuni.returneverytimeserver.model.common.Image;
import com.seohyuni.returneverytimeserver.model.post.Post;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = Notice.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "notice_id", nullable = false)
  private Notice notice;

  @ManyToOne(targetEntity = Image.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id", nullable = false)
  private Image image;

}
