package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.post.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findByPostId(Long postId);
}
