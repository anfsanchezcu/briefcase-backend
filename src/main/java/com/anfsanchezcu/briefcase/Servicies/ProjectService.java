package com.anfsanchezcu.briefcase.Servicies;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anfsanchezcu.briefcase.Controllers.CloudinaryController;
import com.anfsanchezcu.briefcase.DTO.ProjectDTO;
import com.anfsanchezcu.briefcase.DTO.ProjectPreviewtDTO;
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

  public ProjectDTO getProjectById(Long id) {
    Project project = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    return convertToDTO(project);
  }

  @Override
  @Transactional
  public List<ProjectPreviewtDTO> getProjects() { 
    return repository.findAllPreviewsDTO();
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
      skills.addAll(skillService.saveAll(projectDTO.trasnformToSkillList()));

    Project projectEntity = new Project();
    projectEntity.setTitle(projectDTO.getTitle());
    projectEntity.setDescription(projectDTO.getDescription());
    projectEntity.setGithubLink(projectDTO.getGithub());
    projectEntity.setDemoUrl(projectDTO.getDemo());
    projectEntity.setImageUrl(imageUrl);
    projectEntity.setSkills(skills);

    return projectEntity;
  }

  @Override
  @Transactional
  public Project update(Long id, ProjectDTO project) {
    Project projectDB = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException());

    projectDB.setDemoUrl(project.getDemo());
    projectDB.setDescription(project.getDescription());
    projectDB.setGithubLink(project.getGithub());
    projectDB.setTitle(project.getTitle());
    repository.save(projectDB);
    return null;
  }


  public ProjectDTO convertToDTO(Project project) {
    ProjectDTO projectDTO = new ProjectDTO();
    projectDTO.setTitle(project.getTitle());
    projectDTO.setDescription(project.getDescription());
    projectDTO.setGithub(project.getGithubLink());
    projectDTO.setDemo(project.getDemoUrl());
    projectDTO.setImageURL(project.getImageUrl());
    projectDTO.setSkills(convertSkillsToDTO(project.getSkills()));
    return projectDTO;
  }

  private String convertSkillsToDTO(List<Skill> skillsEntity) {
    String skillsDTO = "";
    for (int i = 0; i < skillsEntity.size(); i++) {
      skillsDTO += skillsEntity.get(i).getName();
      if(i != skillsEntity.size())
        skillsDTO +=",";
    }

    return skillsDTO;
  }
}
