package com.anfsanchezcu.briefcase.DTO;

import java.util.List;


public class ExperienceDTO {

  private String company;
  private String position;
  private String description;
  private String date;
  private String imageLink;
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
  public String getImageLink() {
    return imageLink;
  }
  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }
  public List<SkillDTO> getSkills() {
    return skills;
  }
  public void setSkills(List<SkillDTO> skills) {
    this.skills = skills;
  }

  
}
