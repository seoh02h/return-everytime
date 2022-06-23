package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
