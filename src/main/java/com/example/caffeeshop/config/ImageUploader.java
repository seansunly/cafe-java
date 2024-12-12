package com.example.caffeeshop.config;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageUploader {

    public String uploadImage(MultipartFile image) {
        try {
            // Define the upload directory
            String uploadDir = "uploads/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs(); // Create the directory if it doesn't exist
            }

            // Generate a unique file name
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

            // Save the file
            Path filePath = Paths.get(uploadDir, fileName);
            Files.copy(image.getInputStream(), filePath);

            // Return the file path or URL (depending on your needs)
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image: " + e.getMessage(), e);
        }
    }
}
