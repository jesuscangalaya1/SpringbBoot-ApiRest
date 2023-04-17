package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dto.RestauranteDto;
import com.crud.PracticandoDWEC.mappers.RestauranteMapper;
import com.crud.PracticandoDWEC.persistence.repository.RestauranteRespository;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRespository restauranteRespository;
    private final RestauranteMapper mapper;

    public List<Restaurante> list() {
        return restauranteRespository.findAll();
    }

    public Restaurante getRestaurantId(Long id) {
        return restauranteRespository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurante with id " + id + " not found"));
    }

    public List<Restaurante> getRestaurantById(Long restauranteId) {
        return restauranteRespository.findAllById(Collections.singleton(restauranteId));
    }

    public RestauranteDto updateRestaurant(RestauranteDto restauranteDto, Long id) {
        Restaurante restaurante = restauranteRespository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task with id " + id + " not found"));

        restaurante.setNombre(restauranteDto.getNombre());
        restaurante.setDescripcion(restauranteDto.getDescripcion());

        Restaurante restaurantUpdated = restauranteRespository.save(restaurante);
        return mapper.mapearDto(restaurantUpdated);
    }


    public RestauranteDto createRestaurant(RestauranteDto restauranteDto) {
        Restaurante restaurante = mapper.mapearEntidad(restauranteDto);
        Restaurante newRestaurante = restauranteRespository.save(restaurante);
        return mapper.mapearDto(newRestaurante);
    }

    public void deleteRestaurante(Long id) {
        Restaurante restaurante = restauranteRespository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task with id " + id + " not found"));
        restauranteRespository.delete(restaurante);
    }

}


