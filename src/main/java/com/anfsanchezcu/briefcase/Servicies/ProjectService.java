package com.anfsanchezcu.briefcase.Servicies;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anfsanchezcu.briefcase.Controllers.CloudinaryController;
import com.anfsanchezcu.briefcase.DTO.ProjectDTO;
import com.anfsanchezcu.briefcase.Entities.Project;
import com.anfsanchezcu.briefcase.Entities.Skill;
import com.anfsanchezcu.briefcase.Repositories.ProjectsRespository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProjectService implements ProjectServiceInterface {
  @Autowired
  ProjectsRespository repository;

  @Autowired
  SkillService skillService;
  @Autowired
  private CloudinaryController cloudinaryController;

  @Override
  @Transactional
  public void delete(Long id) {
    Project projectDB = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    repository.delete(projectDB);
  }

  @Override
  @Transactional
  public List<Project> getProyects() {
    return (List<Project>) repository.findAll();
  }

  @Override
  @Transactional
  public Project save(Project projectEntity) {
    return repository.save(projectEntity);
  }

  public Project buildProject(ProjectDTO projectDTO, MultipartFile file) {

    String imageUrl = "";
    if (file != null && !file.isEmpty())
      imageUrl = cloudinaryController.upload("projects", file);
    else if (projectDTO.getImageURL() != null)
      imageUrl = projectDTO.getImageURL();

    List<Skill> skills = new ArrayList<>();
    if (skillService != null && projectDTO.getSkills() != null)
      skills.addAll(skillService.saveAll(projectDTO.getSkills()));

    Project projectEntity = new Project();
    projectEntity.setTitle(projectDTO.getTitle());
    projectEntity.setDescription(projectDTO.getDescription());
    projectEntity.setGithubLink(projectDTO.getGithub());
    projectEntity.setDemoUrl(projectDTO.getDemoUrl());
    projectEntity.setImageUrl(imageUrl);
    projectEntity.setSkills(skills);

    return projectEntity;
  }

  @Override
  @Transactional
  public Project update(Long id, ProjectDTO project) {
    Project projectDB = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException());

    projectDB.setDemoUrl(project.getDemoUrl());
    projectDB.setDescription(project.getDescription());
    projectDB.setGithubLink(project.getGithub());
    projectDB.setTitle(project.getTitle());
    repository.save(projectDB);
    return null;
  }

}
