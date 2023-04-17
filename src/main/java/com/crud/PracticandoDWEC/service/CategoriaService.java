package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dto.CategoriaDto;
import com.crud.PracticandoDWEC.mappers.CategoriaMapper;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import com.crud.PracticandoDWEC.persistence.repository.CategoriaRepository;
import com.crud.PracticandoDWEC.persistence.entity.Categoria;
import com.crud.PracticandoDWEC.persistence.repository.RestauranteRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper mapper;
    private final RestauranteRespository restauranteRespository;

    public CategoriaDto createCategoria(Long restauranteId, CategoriaDto categoriaDto) {
        Categoria categoria = mapper.mapearEntidad(categoriaDto);
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        categoria.setRestaurante(restaurante);
        Categoria newCategoria = categoriaRepository.save(categoria);
        restaurante.getCategorias().add(newCategoria);
        return mapper.mapearDto(newCategoria);
    }

    public CategoriaDto updateCategoria (Long restauranteId, Long id, CategoriaDto categoriaDto){
        var restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        if (!categoria.getRestaurante().getId().equals(restaurante.getId()))
            throw new RuntimeException("La categoria no pertenece al restaurante");

        categoria.setCategory(categoriaDto.getCategory());

        Categoria newCategoria = categoriaRepository.save(categoria);
        return mapper.mapearDto(newCategoria);
    }

    public List<CategoriaDto> getCategoryForRestaurantById (Long restauranteId){
        List<Categoria> categorias = categoriaRepository.findByRestauranteId(restauranteId);
        return categorias.stream().map(categoria -> mapper.mapearDto(categoria))
                                  .collect(Collectors.toList());
    }

    public Categoria getCategoryById (Long restauranteId, Long id){
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        if (!categoria.getRestaurante().getId().equals(restaurante.getId()))
            throw new RuntimeException("La categoria no pertenece al restaurante");

        return categoria;
    }


    public void deleteCategoria(Long restauranteId, Long id) {
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        if (!categoria.getRestaurante().getId().equals(restaurante.getId()))
            throw new RuntimeException("La categoria no pertenece al restaurante");

        categoriaRepository.delete(categoria);
    }
}
