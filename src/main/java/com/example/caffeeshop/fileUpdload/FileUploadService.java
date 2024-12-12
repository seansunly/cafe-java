package com.example.caffeeshop.fileUpdload;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {

    void deleteByFileName(String fileName);

    List<FileUploadResponse> uploadMultiple(List<MultipartFile> files);

    FileUploadResponse upload(MultipartFile file);
}
