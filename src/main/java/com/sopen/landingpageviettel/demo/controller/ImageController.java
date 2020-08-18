package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.service.ServiceResult;
import com.sopen.landingpageviettel.demo.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Base64;

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

    @PostMapping("uploadMultiFile")
    public ResponseEntity<ServiceResult> uploadMultiFile(@RequestParam("files") MultipartFile[] files) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            serviceResult = imageServiceImpl.storeMultiFile(files);
            return new ResponseEntity<>(serviceResult, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e);
            serviceResult.setMessage("error");
            return new ResponseEntity<>(serviceResult, HttpStatus.NOT_ACCEPTABLE);
        }
    }

//    @GetMapping("/{id}")
//    public ServiceResult getImage(@PathVariable Long id) {
//        return imageServiceImpl.getFile(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.IMAGE_JPEG);
            byte[] response = imageServiceImpl.getImage(id);
            return ResponseEntity.ok().headers(httpHeaders).body(response);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
