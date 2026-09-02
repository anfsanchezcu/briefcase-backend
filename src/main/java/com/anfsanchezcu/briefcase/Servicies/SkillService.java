package com.anfsanchezcu.briefcase.Servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.anfsanchezcu.briefcase.Entities.Skill;
import com.anfsanchezcu.briefcase.Repositories.SkillRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SkillService implements SkillServiceInterface {

  @Autowired
  private SkillRepository repository;

  @Override
  @Transactional
  public void delete(Long id) {
    Skill skillDB = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    repository.delete(skillDB);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Skill> getSkills() {
    List<Skill> skills = (List<Skill>) repository.findAll();
    return skills;
  }

  @Override
  @Transactional
  public Skill save(Skill skill) {
    String skillName = skill.getName().trim().toUpperCase();
    String skillImage = skill.getImage();

    Optional<Skill> skillOptional = repository.findFirstByNameIgnoreCase(skillName);
    if (skillOptional.isPresent())
      return skillOptional.get();

    skill.setName(skillName);
    skill.setImage(skillImage);
    return repository.save(skill);
  }

  @Override
  @Transactional
  public List<Skill> saveAll(List<Skill> skills) {
     List<Skill> savedSkills = new ArrayList<>();
    for (Skill skill : skills){
      savedSkills.add(this.save(skill));
    } 
    return savedSkills;
  }

  @Override
  @Transactional
  public Skill update(Long id, Skill skill) {
    Skill skillDB = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));

    skillDB.setName(skill.getName());
    skillDB.setImage(skill.getImage());
    repository.save(skillDB);
    return null;
  }

}
