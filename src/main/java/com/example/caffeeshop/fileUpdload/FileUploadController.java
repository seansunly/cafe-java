package com.example.caffeeshop.fileUpdload;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the front-end
public class FileUploadController {
    private final FileUploadService fileUploadService;
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{fileName}")
    void deleteByFileName(@PathVariable String fileName) {
        fileUploadService.deleteByFileName(fileName);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/multiple")
    List<FileUploadResponse> uploadMultiple(@RequestPart List<MultipartFile> files) {
        System.out.println("Test upload multiple");
        return fileUploadService.uploadMultiple(files);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    FileUploadResponse upload(@RequestPart MultipartFile file) {
        return fileUploadService.upload(file);
    }
}