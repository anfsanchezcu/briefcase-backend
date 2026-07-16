package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.anfsanchezcu.briefcase.DTO.ProjectDTO;
import com.anfsanchezcu.briefcase.Entities.Project;

public interface ProjectServiceInterface {
  public List<Project> getProyects();

  public Project save(Project project);
  
  public Project buildProject(ProjectDTO projectDTO, MultipartFile file);
  
  public void delete(Long id);

  public Project update(Long id, ProjectDTO project);
}
