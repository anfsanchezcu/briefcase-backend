package com.anfsanchezcu.briefcase.DTO;

import java.util.List;

import jakarta.validation.constraints.NotBlank;


public class ExperienceDTO {

  @NotBlank(message = "Company is required")
  private String company;

  @NotBlank(message = "Position is required")
  private String position;

  @NotBlank(message = "Description is required")
  private String description;

  @NotBlank(message = "Date is required")
  private String date;
  
  private String imageURL;
  private List<SkillDTO> skills;
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getImageURL() {
    return imageURL;
  }
  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }
  public List<SkillDTO> getSkills() {
    return skills;
  }
  public void setSkills(List<SkillDTO> skills) {
    this.skills = skills;
  }

  
}
