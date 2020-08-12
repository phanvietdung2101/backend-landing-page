package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.Image;
import com.sopen.landingpageviettel.demo.repository.ImageRepository;
import com.sopen.landingpageviettel.demo.service.ImageService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ServiceResult storeFile(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setData(file.getBytes());

        imageRepository.save(image);
        return new ServiceResult("ok");
    }

    @Override
    public ServiceResult getFile(Long fileId) {
        Image image = imageRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
        return new ServiceResult(image, "ok");
    }
}
