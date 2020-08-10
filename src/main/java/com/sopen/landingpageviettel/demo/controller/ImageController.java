package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.Image;
import com.sopen.landingpageviettel.demo.repository.ImageRepository;
import com.sopen.landingpageviettel.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/image/")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        imageService.storeFile(file);
    }

    @GetMapping(value = "/{id}")
    public Image getImage(@PathVariable Long id) {
        return imageService.getFile(id);
    }
}
