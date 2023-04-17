package com.crud.PracticandoDWEC.controller;

import com.crud.PracticandoDWEC.dto.ImagenDto;
import com.crud.PracticandoDWEC.service.ImagenService;
import io.github.classgraph.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.apache.tomcat.util.http.fileupload.FileUploadBase.CONTENT_DISPOSITION;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class ImagenController {

    private final ImagenService imagenService;

    @PostMapping("/Restaurante/{restauranteId}/Imagen")
    public ImagenDto createImagen(@PathVariable Long restauranteId, @RequestBody ImagenDto imagenDto) {
        return new ResponseEntity<>(imagenService.createImagen(restauranteId, imagenDto), HttpStatus.CREATED).getBody();
    }
}