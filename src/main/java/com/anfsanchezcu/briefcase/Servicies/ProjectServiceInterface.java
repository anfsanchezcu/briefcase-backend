package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;

import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Entities.Project;

public interface ProjectServiceInterface {
  public List<Project> getProyects();

  public Project save(Project project);

  public void delete(Long id);

  public Project update(Long id, Project project);
}
