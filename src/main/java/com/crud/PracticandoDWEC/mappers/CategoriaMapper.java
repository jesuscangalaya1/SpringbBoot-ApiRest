package com.crud.PracticandoDWEC.mappers;

import com.crud.PracticandoDWEC.dto.CategoriaDto;
import com.crud.PracticandoDWEC.persistence.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper implements IMapper<CategoriaDto, Categoria> {

    @Override
    public Categoria mapearEntidad(CategoriaDto categoriaDto) {
        return Categoria.builder()
                .category(categoriaDto.getCategory())
                .build();
    }

    @Override
    public CategoriaDto mapearDto(Categoria categoria) {
        return CategoriaDto.builder()
                .category(categoria.getCategory())
                .build();
    }
}
