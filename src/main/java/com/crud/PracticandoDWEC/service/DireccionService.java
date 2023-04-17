package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dto.DireccionDto;
import com.crud.PracticandoDWEC.dto.RestauranteDto;
import com.crud.PracticandoDWEC.mappers.DireccionMapper;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import com.crud.PracticandoDWEC.persistence.repository.DirrecionRespository;
import com.crud.PracticandoDWEC.persistence.entity.Direccion;
import com.crud.PracticandoDWEC.persistence.repository.RestauranteRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DireccionService {

    private final DirrecionRespository direccionRepository;
    private final RestauranteRespository restauranteRespository;
    private final DireccionMapper mapper;



    public List<DireccionDto> getAllDirecciones() {
        List<Direccion> direccions = direccionRepository.findAll();
        return direccions.stream()
                .map(direccion -> mapper.mapearDto(direccion))
                .collect(Collectors.toList());
    }


    public DireccionDto getDirectionForRestaurante (Long restaurantId){
        Restaurante restaurante = restauranteRespository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurante no encontrado: " + restaurantId));

        Direccion direccion = restaurante.getDirecciones();
        if (direccion == null)
            throw new IllegalStateException("El restaurante no tiene una dirección asignada.");

        return mapper.mapearDto(direccion);
    }

    public DireccionDto createDireccion(Long restauranteId, DireccionDto direccionDto) {
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Nombre no encontrado" + restauranteId + " Not found"));

        if (restaurante.getDirecciones() != null)
            throw new IllegalStateException("El restaurante ya tiene una dirección asignada");

        Direccion direccion = mapper.mapearEntidad(direccionDto);

        if (direccion == null)
            throw new IllegalArgumentException("La dirección no puede ser nula");

        restaurante.setDirecciones(direccion);
        direccion.setRestaurante(restaurante);

        direccionRepository.save(direccion);

        return mapper.mapearDto(direccion);
    }

    public DireccionDto updateDireccion(Long restauranteId, DireccionDto direccionDto){
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Restaurante no encontrado: " + restauranteId));

        // Verificar que el restaurante tenga una dirección asignada
        Direccion direccion = restaurante.getDirecciones();
        if (direccion == null) {
            throw new IllegalStateException("El restaurante no tiene una dirección asignada.");
        }

        // Actualizar los campos de la dirección existente con los valores del objeto DireccionDto
        direccion.setCalle(direccionDto.getCalle());
        // ...

        // Guardar los cambios en el objeto Restaurante y devolver la dirección actualizada como un objeto DireccionDto
        Direccion direccionActualizada = direccionRepository.save(direccion);
        return mapper.mapearDto(direccionActualizada);
    }


    public void deleteDirection(Long restauranteId) {
        Restaurante restaurante = restauranteRespository.findById(restauranteId)
                .orElseThrow(() -> new NoSuchElementException("Restaurante no encontrado: " + restauranteId));

        // Verificar que el restaurante tenga una dirección asignada
        Direccion direccion = restaurante.getDirecciones();
        if (direccion == null)
            throw new IllegalStateException("El restaurante no tiene una dirección asignada.");

        // Eliminar la dirección del restaurante
        restaurante.setDirecciones(null);
        direccion.setRestaurante(null);
        direccionRepository.delete(direccion);

        // Actualizar el objeto Restaurante en la base de datos
        restauranteRespository.save(restaurante);
    }
}
