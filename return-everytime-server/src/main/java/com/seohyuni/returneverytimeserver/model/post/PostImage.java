package com.seohyuni.returneverytimeserver.model.post;

import com.seohyuni.returneverytimeserver.model.common.Image;
import com.seohyuni.returneverytimeserver.model.notice.Notice;
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
public class PostImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = Post.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @ManyToOne(targetEntity = Image.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id", nullable = false)
  private Image image;

}
