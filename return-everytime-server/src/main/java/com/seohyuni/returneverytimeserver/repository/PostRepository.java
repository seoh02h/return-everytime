package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.post.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByTitleContains(String keyword);
}
