package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Entities.Skill;
import com.anfsanchezcu.briefcase.Repositories.ExperienceRepository;
import com.anfsanchezcu.briefcase.Repositories.SkillRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExperienceService implements ExperienceServiceInterface {
  @Autowired
  private ExperienceRepository repository;

  @Autowired
  private SkillService skillService;

  @Override
  @Transactional
  public void delete(Long id) {
    Experience experienceDB = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException());
    repository.delete(experienceDB);
  }

  @Override
  @Transactional
  public Experience update(Long id, Experience experience) {
    Optional<Experience> experienceDB = repository.findById(id);

    if (!experienceDB.isPresent())
      experienceDB.orElseThrow(() -> new EntityNotFoundException());

    Experience experienceUpdate = experienceDB.get();
    experienceUpdate.setCompany(experience.getCompany());
    experienceUpdate.setPosition(experience.getPosition());
    experienceUpdate.setDescription(experience.getDescription());
    experienceUpdate.setDate(experience.getDate());
    experienceUpdate.setImageLink(experience.getImageLink());
    experienceUpdate.setSkills(experience.getSkills());
    return this.save(experienceUpdate);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Experience> getExperiences() {
    return (List<Experience>) repository.findAll();
  }

  @Override
  @Transactional
  public Experience save(Experience experience) {
    List<Skill> skills = skillService.saveAll(experience.getSkills());
    experience.setSkills(skills);
    return repository.save(experience);
  }
}
