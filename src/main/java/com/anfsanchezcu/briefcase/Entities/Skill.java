package com.anfsanchezcu.briefcase.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
  name = "skills"
)
public class Skill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

 
  @Column(nullable = true)
  private String image;

  
  public Skill() {
  }

  public Skill(Long id, String name, String image) {
    this.id = id;
    this.name = name;
    this.image = image;
  }
  public Skill(String name, String image) {
    this.name = name;
    this.image = image;
  }


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

   @Override
  public String toString() {
    return "Skill [id=" + id + ", name=" + name + ", image=" + image + "]";
  }


  

}
