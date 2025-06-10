package com.example.imagebank.service;

import com.example.imagebank.model.Image;
import com.example.imagebank.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public Image createImage(Image image) {
        Image savedImage = imageRepository.save(image);
        return savedImage;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public Optional<Image> updateImage(Long id, Image imageDetails) {
        return imageRepository.findById(id).map(image -> {
            image.setNome(imageDetails.getNome());
            image.setUrl(imageDetails.getUrl());
            return imageRepository.save(image);
        });
    }
}