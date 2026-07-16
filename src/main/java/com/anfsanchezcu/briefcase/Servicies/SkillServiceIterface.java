package com.anfsanchezcu.briefcase.Servicies;

import java.util.List;

import com.anfsanchezcu.briefcase.DTO.SkillDTO;
import com.anfsanchezcu.briefcase.Entities.Skill;

public interface SkillServiceIterface {
  public List<Skill> getSkills();

  public Skill save(Skill skill);

  public List<Skill> saveAll(List<SkillDTO> skill);

  public void delete(Long id);

  public Skill update(Long id, Skill skill);
}
