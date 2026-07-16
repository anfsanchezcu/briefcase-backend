package com.anfsanchezcu.briefcase.DTO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProjectDTO {

  @NotBlank(message = "Title is required")
  @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
  private String title;

  @NotBlank(message = "Description is required")
  @Size(max = 500, message = "Description must be at most 500 characters")
  private String description;

  @NotBlank(message = "GitHub link is required")
  @Size(min = 50, max = 200, message = "GitHub link must be between 50 and 200 characters")
  private String github;

  private String demo;
  private MultipartFile imageFile;

  private List<SkillDTO> skills;

  public ProjectDTO() {

  }

  public ProjectDTO(String title, String description, String githubLink, String demoUrl, MultipartFile imageFile,
      List<SkillDTO> skills) {
    this.title = title;
    this.description = description;
    this.github = githubLink;
    this.demo = demoUrl;
    this.imageFile = imageFile;
    this.skills = skills;
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

  public String getDemoUrl() {
    return demo;
  }

  public void setDemoUrl(String demoUrl) {
    this.demo = demoUrl;
  }

  public MultipartFile getImageFile() {
    return imageFile;
  }

  public void setImageFile(MultipartFile imageFile) {
    this.imageFile = imageFile;
  }

  public List<SkillDTO> getSkills() {
    return skills;
  }

  public void setSkills(List<SkillDTO> skills) {
    this.skills = skills;
  }

}
