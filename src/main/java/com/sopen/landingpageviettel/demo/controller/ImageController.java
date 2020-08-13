package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.service.ServiceResult;
import com.sopen.landingpageviettel.demo.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/image/")
public class ImageController {
    @Autowired
    ImageServiceImpl imageServiceImpl;

    @PostMapping("/uploadFile")
    public ServiceResult uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        return imageServiceImpl.storeFile(file);
    }

    @GetMapping("/{id}")
    public ServiceResult getImage(@PathVariable Long id) {
        return imageServiceImpl.getFile(id);
    }
}
