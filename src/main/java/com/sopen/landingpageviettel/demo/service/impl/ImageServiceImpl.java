package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.Image;
import com.sopen.landingpageviettel.demo.repository.ImageRepository;
import com.sopen.landingpageviettel.demo.service.ImageService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ServiceResult storeFile(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setData(file.getBytes());
        image.setName(file.getOriginalFilename());
        image = imageRepository.save(image);
        // return image with only id
        image.setData(null);
        return new ServiceResult(image, "ok");
    }

    @Override
    public ServiceResult getFile(Long fileId) {
        Image image = imageRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
        return new ServiceResult(image, "ok");
    }

    @Override
    public ServiceResult storeMultiFile(MultipartFile[] files) throws IOException {
        List<Image> imageList = getImageList(files);
        imageRepository.saveAll(imageList);
        return new ServiceResult(getResponseImageList(imageList), "ok");
    }

    @Override
    public byte[] getImage(Long fileId) {
        Optional<Image> image = imageRepository.findById(fileId);
        if(image.isPresent()){
            return image.get().getData();
        } else {
            throw new RuntimeException("Not found file");
        }
    }

    public List<Image> getImageList(MultipartFile[] files) throws IOException {
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile file : files) {
            Image image = new Image();
            image.setData(file.getBytes());
            image.setName(file.getOriginalFilename());
            imageList.add(image);
        }
        return imageList;
    }

    public List<Image> getResponseImageList(List<Image> imageList) {
        imageList.forEach(image -> image.setData(null));
        return imageList;
    }
}
