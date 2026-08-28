package com.anfsanchezcu.briefcase.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.anfsanchezcu.briefcase.DTO.ProjectDTO;
import com.anfsanchezcu.briefcase.DTO.ProjectPreviewtDTO;
import com.anfsanchezcu.briefcase.Entities.Project;
import com.anfsanchezcu.briefcase.Servicies.ProjectService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping()
  public List<ProjectPreviewtDTO> getProjects() {
    return projectService.getProjects();
  }

  @GetMapping("/{id}")
  public ProjectDTO getProject(@PathVariable Long id) {
    return projectService.getProjectById(id);
  }

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ProjectDTO> saveProject(
    @Valid @ModelAttribute ProjectDTO projectDTO,
    @RequestParam("image") MultipartFile file) 
    { 
      if (file.isEmpty() && projectDTO.getImageURL() == null) 
        throw new IllegalArgumentException("Image is required");

      System.out.println("🧠BuildedProject: " + projectDTO);
      Project BuildedProject = projectService.buildProject(projectDTO,file);
      System.out.println("🎮BuildedProject: " + BuildedProject);

      Project SavedProject = projectService.save(BuildedProject);
      System.out.println("SavedProject: " + SavedProject);
      return ResponseEntity.status(HttpStatus.CREATED).body(projectService.convertToDTO(SavedProject));
  }

}
