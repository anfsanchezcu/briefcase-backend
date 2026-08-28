package com.anfsanchezcu.briefcase.DTO;

public class ProjectPreviewtDTO {

  private Long id;
  private String title;
  private String description;
  private String imageUrl;

  public ProjectPreviewtDTO( String title, String description,String imageFile){
    this.title = title;
    this.description = description;
    this.imageUrl = imageFile;
  }

  public ProjectPreviewtDTO(Long id, String title, String description,String imageFile){
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageUrl = imageFile;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
