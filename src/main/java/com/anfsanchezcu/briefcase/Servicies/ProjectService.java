package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Entities.Project;
import com.anfsanchezcu.briefcase.Repositories.ProjectsRespository;

import jakarta.persistence.EntityNotFoundException;

public class ProjectService implements ProjectServiceInterface{
  @Autowired
  ProjectsRespository repository;


  @Override
  public void delete(Long id) {
    Project projectDB = repository.findById(id).
      orElseThrow(()-> new EntityNotFoundException() );

    repository.delete(projectDB);
  }

  @Override
  public List<Project> getProyects() {
    return (List<Project>)repository.findAll();
  }

  @Override
  public Project save(Project project) {
    return repository.save(project);
  }

  @Override
  public Project update(Long id, Project project) {
    Project projectDB = repository.findById(id)
      .orElseThrow(()-> new EntityNotFoundException());
    
    projectDB.setDemoUrl(project.getDemoUrl());
    projectDB.setDescription(project.getDescription());
    projectDB.setGithubLink(project.getGithubLink());
    projectDB.setImageUrl(project.getImageUrl());
    projectDB.setSkills(project.getSkills());
    projectDB.setTitle(project.getTitle());

    repository.save(projectDB);

    return null;
  }

}
