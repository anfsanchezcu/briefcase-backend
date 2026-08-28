package com.anfsanchezcu.briefcase.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.anfsanchezcu.briefcase.DTO.ProjectPreviewtDTO;
import com.anfsanchezcu.briefcase.Entities.Project;

public interface ProjectsRespository extends CrudRepository<Project, Long> {

  @Query("SELECT new com.anfsanchezcu.briefcase.DTO.ProjectPreviewtDTO(p.id, p.title,p.description,p.imageUrl) FROM Project p")
  public List<ProjectPreviewtDTO> findAllPreviewsDTO();

}
