package com.seohyuni.returneverytimeserver.model.board;

import com.seohyuni.returneverytimeserver.model.user.User;
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

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String content;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(targetEntity = Post.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @ManyToOne(targetEntity = Comment.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id")
  private Comment comment;

  @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
  private List<Comment> commentList;

//  @ManyToOne(targetEntity = Comment.class, fetch = FetchType.LAZY)
//  @JoinColumn(name = "comment_id", nullable = true)
//  private Comment comment;


}
