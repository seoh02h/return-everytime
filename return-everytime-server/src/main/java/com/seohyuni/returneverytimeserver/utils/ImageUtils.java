package com.seohyuni.returneverytimeserver.utils;

import com.seohyuni.returneverytimeserver.model.common.Image;
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
public class ImageUtils {

  private static String imagePath;

  @Value("${app.resources.url}")
  public void setImagePath(String value) {
    imagePath = value;
  }


  public static String getImageUrl(MultipartFile image) throws Exception {

    String extension = FilenameUtils.getExtension(image.getOriginalFilename());
    String fileName = String.valueOf(new Date().getTime()) + "." + extension;
    String classpath = ResourceUtils.getURL("classpath:static/").getPath();
    String filePath = classpath + fileName;
    File saveFile = new File(filePath);
    image.transferTo(saveFile);

    return imagePath + fileName;
  }

  public static Image getImage(MultipartFile image) throws Exception{
    String extension = FilenameUtils.getExtension(image.getOriginalFilename());
    String fileName = String.valueOf(new Date().getTime()) + "." + extension;
    String classpath = ResourceUtils.getURL("classpath:static/").getPath();
    String filePath = classpath + fileName;
    File saveFile = new File(filePath);
    image.transferTo(saveFile);

    return Image.builder()
        .url(imagePath + fileName)
        .oriName(image.getOriginalFilename())
        .build();

  }


}
