package com.seohyuni.returneverytimeserver.model.notice;

import com.seohyuni.returneverytimeserver.model.common.BaseTimeEntity;
import com.seohyuni.returneverytimeserver.model.post.Comment;
import com.seohyuni.returneverytimeserver.model.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
  private List<NoticeImage> noticeImageList;

  public List<NoticeImage> getNoticeImageList() {
    return this.noticeImageList == null ? new ArrayList<>() : this.noticeImageList;
  }


  public Boolean isEditable() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    if (securityContext.getAuthentication().getClass().equals(AnonymousAuthenticationToken.class)) {
      return false;
    }

    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();

    if (this.user.getEmail().equals(userDetails.getUsername())) {
      return true;
    }

    return false;
  }

}
