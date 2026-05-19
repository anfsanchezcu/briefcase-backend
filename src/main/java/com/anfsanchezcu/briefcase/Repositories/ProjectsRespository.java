package com.anfsanchezcu.briefcase.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.anfsanchezcu.briefcase.Entities.Project;

public interface ProjectsRespository extends CrudRepository<Project, Long> {

}
