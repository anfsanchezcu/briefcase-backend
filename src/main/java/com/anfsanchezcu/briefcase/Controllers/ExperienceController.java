package com.anfsanchezcu.briefcase.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Servicies.ExperienceService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

  @Autowired
  private ExperienceService Service;

  @GetMapping()
  public List<Experience> getExperiences(){
    return Service.getExperiences();
  }

  @PostMapping()
  public ResponseEntity<Experience> saveExperience(@RequestBody Experience experience){
    Experience savedExperience = Service.save(experience);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedExperience);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteExperience(@PathVariable Long id){
    Service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Experience> UpdateExperience(@PathVariable Long id, @RequestBody Experience experience) {
    Experience entity = Service.update(id, experience);
    return ResponseEntity.ok(entity);
  }
}