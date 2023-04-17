package com.crud.PracticandoDWEC.mappers;

import com.crud.PracticandoDWEC.dto.DireccionDto;
import com.crud.PracticandoDWEC.persistence.entity.Direccion;
import org.springframework.stereotype.Component;

@Component
public class DireccionMapper implements IMapper<DireccionDto, Direccion>{

    @Override
    public Direccion mapearEntidad(DireccionDto direccionDto) {
        return Direccion.builder()
                .calle(direccionDto.getCalle())
                .build();
    }

    @Override
    public DireccionDto mapearDto(Direccion direccion) {
        return DireccionDto.builder()
                .calle(direccion.getCalle())
                .build();
    }
}
