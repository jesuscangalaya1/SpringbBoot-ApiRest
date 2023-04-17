package com.crud.PracticandoDWEC.mappers;

import com.crud.PracticandoDWEC.dto.ImagenDto;
import com.crud.PracticandoDWEC.persistence.entity.Imagen;
import org.springframework.stereotype.Component;

@Component
public class ImagenMapper implements IMapper<ImagenDto, Imagen>{

    @Override
    public Imagen mapearEntidad(ImagenDto imagenDto) {
        return Imagen.builder()
                .nombre(imagenDto.getNombre())
                .build();
    }

    @Override
    public ImagenDto mapearDto(Imagen imagen) {
        return ImagenDto.builder()
                .nombre(imagen.getNombre())
                .build();
    }
}
