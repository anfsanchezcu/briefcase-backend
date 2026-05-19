package com.anfsanchezcu.briefcase.Entities;

import java.util.ArrayList;
import java.util.List;

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
  private String imageLink;

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

  public Experience(Long id, String company, String position, String description, String date, String imageLink,
      List<Skill> skills) {
    this.id = id;
    this.company = company;
    this.position = position;
    this.description = description;
    this.date = date;
    this.imageLink = imageLink;
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

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

}
