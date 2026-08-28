package com.anfsanchezcu.briefcase.Servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.anfsanchezcu.briefcase.Controllers.CloudinaryController;
import com.anfsanchezcu.briefcase.DTO.ExperienceDTO;
import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Repositories.ExperienceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExperienceService implements ExperienceServiceInterface {
  @Autowired
  private ExperienceRepository repository;

  @Autowired
  private SkillService skillService;

  @Autowired
  private CloudinaryController cloudinaryController;

  @Override
  @Transactional
  public void delete(Long id) {
    Experience experienceDB = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException());
    repository.delete(experienceDB);
  }

  @Override
  @Transactional
  public Experience update(Long id, Experience experienceEntity) {
    Optional<Experience> experienceDB = repository.findById(id);

    if (!experienceDB.isPresent())
      experienceDB.orElseThrow(() -> new EntityNotFoundException());


    Experience experienceUpdate = experienceDB.get();
    experienceUpdate.setCompany(experienceEntity.getCompany());
    experienceUpdate.setPosition(experienceEntity.getPosition());
    experienceUpdate.setDescription(experienceEntity.getDescription());
    experienceUpdate.setDate(experienceEntity.getDate());
    experienceUpdate.setImageURL(experienceEntity.getImageURL());
    return repository.save(experienceUpdate);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ExperienceDTO> getExperiences() {
    List <Experience> ListExperience= (List <Experience>) repository.findAll();
    List<ExperienceDTO> ListDTO = new ArrayList<>();

    for (Experience experience : ListExperience) {
      ListDTO.add(experience.transformToDTO());
    }
    return ListDTO;
  }

  @Override
  @Transactional
  public Experience save(Experience experienceEntity) {
    return repository.save(experienceEntity);
  }


  public Experience buildExperience(ExperienceDTO experienceDTO, MultipartFile file) {

    String imageUrl = "";
    if (file != null && !file.isEmpty())
      imageUrl = cloudinaryController.upload("projects", file);
    else if (experienceDTO.getImageURL() != null)
      imageUrl = experienceDTO.getImageURL();

    Experience experienceEntity = new Experience();
    experienceEntity.setCompany(experienceDTO.getCompany());
    experienceEntity.setPosition(experienceDTO.getPosition());
    experienceEntity.setDescription(experienceDTO.getDescription());
    experienceEntity.setDate(experienceDTO.getDate());
    experienceEntity.setImageURL(imageUrl);
    experienceEntity.setSkills(skillService.saveAll(experienceDTO.getSkillsList()));

    return experienceEntity;
  }
}
