package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anfsanchezcu.briefcase.DTO.ExperienceDTO;
import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Entities.Skill;
import com.anfsanchezcu.briefcase.Repositories.ExperienceRepository;

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
  public Experience update(Long id, ExperienceDTO experience) {
    Optional<Experience> experienceDB = repository.findById(id);

    if (!experienceDB.isPresent())
      experienceDB.orElseThrow(() -> new EntityNotFoundException());

    Experience experienceUpdate = experienceDB.get();
    experienceUpdate.setCompany(experience.getCompany());
    experienceUpdate.setPosition(experience.getPosition());
    experienceUpdate.setDescription(experience.getDescription());
    experienceUpdate.setDate(experience.getDate());
    experienceUpdate.setImageLink(experience.getImageLink());
    experienceUpdate.setSkills(skillService.saveAll(experience.getSkills()));
    return repository.save(experienceUpdate);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Experience> getExperiences() {
    return (List<Experience>) repository.findAll();
  }

  @Override
  @Transactional
  public Experience save(ExperienceDTO experience) {
    List<Skill> skills = skillService.saveAll(experience.getSkills());

    Experience experienceEntity = new Experience();
    experienceEntity.setCompany(experience.getCompany());
    experienceEntity.setPosition(experience.getPosition());
    experienceEntity.setDescription(experience.getDescription());
    experienceEntity.setDate(experience.getDate());
    experienceEntity.setImageLink(experience.getImageLink());
    experienceEntity.setSkills(skills);
    return repository.save(experienceEntity);
  }
}
