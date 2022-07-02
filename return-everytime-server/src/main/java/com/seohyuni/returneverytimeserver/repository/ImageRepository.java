package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.common.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
