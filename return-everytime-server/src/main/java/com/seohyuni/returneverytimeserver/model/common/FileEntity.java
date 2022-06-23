package com.seohyuni.returneverytimeserver.model.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {

  @Column(nullable = false)
  private String fileName;

  @Column(nullable = false)
  private String fileUrl;

  @Column(nullable = false)
  private String fileOriName;

}
