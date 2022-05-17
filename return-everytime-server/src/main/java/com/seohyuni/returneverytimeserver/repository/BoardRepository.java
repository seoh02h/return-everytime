package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
