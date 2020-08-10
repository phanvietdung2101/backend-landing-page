package com.sopen.landingpageviettel.demo.service;

import com.sopen.landingpageviettel.demo.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ServiceResult storeFile(MultipartFile file) throws IOException;
    ServiceResult getFile(Long fileId);
}
