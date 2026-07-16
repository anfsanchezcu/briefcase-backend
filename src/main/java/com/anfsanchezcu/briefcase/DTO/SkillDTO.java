package com.anfsanchezcu.briefcase.DTO;

import org.springframework.web.multipart.MultipartFile;

public class 
SkillDTO {
 
  private String name;
  private MultipartFile image;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public MultipartFile getImage() {
    return image;
  }
  public void setImage(MultipartFile image) {
    this.image = image;
  }
  

  
}
