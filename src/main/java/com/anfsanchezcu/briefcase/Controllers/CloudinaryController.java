package com.anfsanchezcu.briefcase.Controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anfsanchezcu.briefcase.Servicies.CloudinaryService;


@RestController
@RequestMapping("/api/upload")
public class CloudinaryController{

  @Autowired
  private CloudinaryService cloudinaryService;
  

  @PostMapping()
  public ResponseEntity<Map<String, String>> upload(@RequestParam String folder,@RequestParam("image") MultipartFile file) throws IOException {

      String imageUrl = cloudinaryService.upload(file, folder);

      return ResponseEntity.ok(Map.of("imageUrl", imageUrl));
  }
}
