package com.anfsanchezcu.briefcase.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anfsanchezcu.briefcase.Entities.Experience;

public interface ExperienceRepository extends  CrudRepository<Experience, Long> {

}
