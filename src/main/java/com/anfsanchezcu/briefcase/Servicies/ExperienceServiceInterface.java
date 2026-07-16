package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;

import com.anfsanchezcu.briefcase.DTO.ExperienceDTO;
import com.anfsanchezcu.briefcase.Entities.Experience;

public interface ExperienceServiceInterface {
  public List<Experience> getExperiences();

  public Experience save(ExperienceDTO experience);

  public void delete(Long id);

  public Experience update(Long id, ExperienceDTO experience);
}
