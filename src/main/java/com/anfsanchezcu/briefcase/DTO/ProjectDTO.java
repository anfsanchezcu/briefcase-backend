package com.anfsanchezcu.briefcase.DTO;

import java.util.ArrayList;
import java.util.List;

import com.anfsanchezcu.briefcase.Entities.Skill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProjectDTO {

  @NotBlank(message = "Title is required")
  @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
  private String title;

  @NotBlank(message = "Description is required")
  @Size(max = 1000, message = "Description must be at most 500 characters")
  private String description;

  @NotBlank(message = "GitHub link is required")
  @Size(min = 10, max = 200, message = "GitHub link must be between 50 and 200 characters")
  private String github;

  private String imageURL;
  private String demo;
  private String skills;

  public ProjectDTO() {

  }

  public ProjectDTO(String title, String description, String githubLink, String demoUrl, String imageFile,
      String skills) {
    this.title = title;
    this.description = description;
    this.github = githubLink;
    this.demo = demoUrl;
    this.imageURL = imageFile;
    this.skills = skills;
  }

  public List<Skill> trasnformToSkillList() {
    String arraySkills[] = this.skills.split(",");
    List<Skill> skillsDTOList = new ArrayList<>();

    for (String skillName : arraySkills) {
      Skill skill = new Skill(skillName, null);
      skillsDTOList.add(skill);
    }
    return skillsDTOList;
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

  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public String getDemo() {
    return demo;
  }

  public void setDemo(String demoUrl) {
    this.demo = demoUrl;
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

  @Override
  public String toString() {
    return "ProjectDTO [title=" + title + ", description=" + description + ", github=" + github + ", imageURL="
        + imageURL + ", demo=" + demo + ", skills=" + skills + "]";
  }

}
