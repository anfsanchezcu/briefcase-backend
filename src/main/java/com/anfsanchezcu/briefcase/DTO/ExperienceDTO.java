package com.anfsanchezcu.briefcase.DTO;

import java.util.ArrayList;
import java.util.List;

import com.anfsanchezcu.briefcase.Entities.Skill;

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
  private String skills;
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
  public String getSkills() {
    return skills;
  }
  public void setSkills(String skills) {
    this.skills = skills;
  }

  public void setSkillsToDTO(List<Skill> skills) {
    String skillsResult = "";
    for (int i = 0; i<skills.size(); i++ ) {

      skillsResult += skills.get(i).getName();
      if(i != skills.size())
        skillsResult += ",";
    }
    this.skills = skillsResult;
  }

  public List<Skill> getSkillsList() {
    List<Skill> skillsList = new ArrayList<>();
    String skills[] = this.skills.split(",");

    for (String name : skills) {
      Skill skill = new Skill(name, null);
      skillsList.add(skill);
    }

    return skillsList;
  }

  
}
