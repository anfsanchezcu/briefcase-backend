package com.anfsanchezcu.briefcase.Entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyects")//TO DO
public class Project {
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  
  private String title;
  private String description;

  @Column(name = "github")
  private String githubLink;

  @Column(name = "demo")
  private String demoUrl;

  @Column(name = "image")
  private String imageUrl;

  @ManyToMany
  @JoinTable(
    name = "projects_skills",
    joinColumns = @JoinColumn(name = "id_project"),
    inverseJoinColumns = @JoinColumn(name = "id_skill")
  )
  private List<Skill> skills;


  public Project() {
    skills = new ArrayList<>();
  }

  public Project( String title, String description, String githubLink, String demoUrl, String imageUrl,
      List<Skill> skills) {
    this.title = title;
    this.description = description;
    this.githubLink = githubLink;
    this.demoUrl = demoUrl;
    this.imageUrl = imageUrl;
    this.skills = skills;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
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

  public String getGithubLink() {
    return githubLink;
  }

  public void setGithubLink(String githubLink) {
    this.githubLink = githubLink;
  }

  public String getDemoUrl() {
    return demoUrl;
  }

  public void setDemoUrl(String demoUrl) {
    this.demoUrl = demoUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  @Override
  public String toString() {
    return "Project [id=" + id + ", title=" + title + ", description=" + description + ", githubLink=" + githubLink
        + ", demoUrl=" + demoUrl + ", imageUrl=" + imageUrl + ", skills=" + skills + "]";
  }
  
  
}
