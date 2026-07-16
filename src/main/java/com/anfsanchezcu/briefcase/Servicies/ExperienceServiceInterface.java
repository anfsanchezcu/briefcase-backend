package com.anfsanchezcu.briefcase.Servicies;
import java.util.List;
import com.anfsanchezcu.briefcase.Entities.Experience;

public interface ExperienceServiceInterface {
  public List<Experience> getExperiences();

  public Experience save(Experience experience);

  public void delete(Long id);

  public Experience update(Long id, Experience experience);
}
