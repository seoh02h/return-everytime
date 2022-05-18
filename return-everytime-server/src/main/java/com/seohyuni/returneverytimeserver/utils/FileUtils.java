package com.seohyuni.returneverytimeserver.utils;

import java.io.File;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class FileUtils {

  private static String imagePath;

  @Value("${app.resources.url}")
  public void setImagePath(String value) {
    imagePath = value;
  }


  public static String getImageUrl(MultipartFile imageFile) throws Exception {

    String extension = FilenameUtils.getExtension(imageFile.getOriginalFilename());
    String fileName = String.valueOf(new Date().getTime()) + "." + extension;
    String classpath = ResourceUtils.getURL("classpath:static/").getPath();
    String filePath = classpath + fileName;
    File saveFile = new File(filePath);
    imageFile.transferTo(saveFile);

    return imagePath + fileName;
  }


}
