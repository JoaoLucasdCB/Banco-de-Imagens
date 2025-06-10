package com.example.imagebank.controller;

import com.example.imagebank.model.Image;
import com.example.imagebank.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*") // Adjust the origin as needed
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        Image createdImage = imageService.createImage(image);
        return ResponseEntity.ok(createdImage);
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Image>> updateImage(@PathVariable Long id, @RequestBody Image image) {
        Optional<Image> updatedImage = imageService.updateImage(id, image);
        return ResponseEntity.ok(updatedImage);
    }
}