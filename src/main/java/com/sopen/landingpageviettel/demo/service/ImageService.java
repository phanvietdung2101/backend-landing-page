package com.sopen.landingpageviettel.demo.service;

import com.sopen.landingpageviettel.demo.models.Image;
import com.sopen.landingpageviettel.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public void storeFile(MultipartFile file) throws Exception{
        Image image = new Image();
        image.setData(file.getBytes());

        imageRepository.save(image);
    }

    public Image getFile(Long fileId) {
        return imageRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));

    }
}
