package com.example.caffeeshop.fileUpdload;

import lombok.Builder;

@Builder
public record FileUploadResponse(
        String name,

        String uri,

        String contentType,

        Long size
) {
}