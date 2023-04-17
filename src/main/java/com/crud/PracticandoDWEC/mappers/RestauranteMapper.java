package com.crud.PracticandoDWEC.mappers;

import com.crud.PracticandoDWEC.dto.RestauranteDto;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper implements IMapper<RestauranteDto, Restaurante> {


    @Override
    public Restaurante mapearEntidad(RestauranteDto restauranteDto) {
        return Restaurante.builder()
                .nombre(restauranteDto.getNombre())
                .descripcion(restauranteDto.getDescripcion())
                .build();
    }

    @Override
    public RestauranteDto mapearDto(Restaurante restaurante) {
        return RestauranteDto.builder()
                .nombre(restaurante.getNombre())
                .descripcion(restaurante.getDescripcion())
                .build();
    }
}
