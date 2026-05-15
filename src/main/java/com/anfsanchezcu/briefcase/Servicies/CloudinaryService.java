package com.anfsanchezcu.briefcase.Servicies;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@Service
public class CloudinaryService {

  private static final Set<String> ALLOWED_FOLDERS = Set.of("companies", "projects", "skills");
  private final Cloudinary cloudinary;

  public CloudinaryService(Cloudinary cloudinary) {
      this.cloudinary = cloudinary;
  }

  public String upload(MultipartFile file, String folder) throws IOException {
    
    if (!ALLOWED_FOLDERS.contains(folder)) 
      throw new IllegalArgumentException("Folder no permitido. Valores válidos: " + ALLOWED_FOLDERS);

    String path = "portfolio/"+folder;
    Map<?, ?> result = cloudinary.uploader().upload(
        file.getBytes(),
        ObjectUtils.asMap("folder", path)
    );

    return result.get("secure_url").toString();
  }
}
