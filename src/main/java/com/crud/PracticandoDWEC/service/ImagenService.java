package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dto.ImagenDto;
import com.crud.PracticandoDWEC.mappers.ImagenMapper;
import com.crud.PracticandoDWEC.persistence.entity.Imagen;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import com.crud.PracticandoDWEC.persistence.repository.ImagenRepository;
import com.crud.PracticandoDWEC.persistence.repository.RestauranteRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
@RequiredArgsConstructor
public class ImagenService {

    private final ImagenRepository imagenRepository;
    private final ImagenMapper mapper;
    private final RestauranteRespository restauranteRespository;









    public ImagenDto createImagen(Long restauranteId, ImagenDto imagenDto){
        Imagen imagen = mapper.mapearEntidad(imagenDto);
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId+ " Not found"));

        imagen.setRestaurante(restaurante);
        Imagen newImagen = imagenRepository.save(imagen);
        restaurante.getImagenes().add(newImagen);
        return mapper.mapearDto(newImagen);

    }

}
