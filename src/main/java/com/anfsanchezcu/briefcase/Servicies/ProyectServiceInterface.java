package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;

import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Entities.Proyect;

public interface ProyectServiceInterface {
  public List<Experience> getProyects();

  public Proyect save(Proyect proyect);

  public void delete(Long id);

  public Proyect update(Long id, Proyect proyect);
}
