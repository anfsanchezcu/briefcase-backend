package com.anfsanchezcu.briefcase.Entities;

import java.util.ArrayList;
import java.util.List;

import com.anfsanchezcu.briefcase.DTO.ExperienceDTO;

import jakarta.persistence.CascadeType;
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
@Table(name = "experiences")
public class Experience {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String company;
  private String position;
  private String description;
  private String date;

  @Column(name = "image")
  private String imageURL;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "experiences_skills",
    joinColumns = @JoinColumn(name = "id_experience"),
    inverseJoinColumns = @JoinColumn(name = "id_skill")
  )
  private List<Skill> skills;

  public Experience() {
    skills = new ArrayList<>();
  }

  public Experience(Long id, String company, String position, String description, String date, String imageURL,
      List<Skill> skills) {
    this.id = id;
    this.company = company;
    this.position = position;
    this.description = description;
    this.date = date;
    this.imageURL = imageURL;
    this.skills = skills;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public ExperienceDTO transformToDTO(){
    ExperienceDTO experienceDTO = new ExperienceDTO();
    experienceDTO.setCompany(this.company);
    experienceDTO.setDate(this.getDate());
    experienceDTO.setDescription(this.description);
    experienceDTO.setImageURL(this.imageURL);
    experienceDTO.setPosition(this.position);
    experienceDTO.setSkillsToDTO(this.skills);

    return experienceDTO;
  }

}
