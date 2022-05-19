package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
