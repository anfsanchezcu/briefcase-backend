package com.anfsanchezcu.briefcase.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anfsanchezcu.briefcase.Entities.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {
  Optional<Skill> findFirstByNameIgnoreCase(String name);
}
