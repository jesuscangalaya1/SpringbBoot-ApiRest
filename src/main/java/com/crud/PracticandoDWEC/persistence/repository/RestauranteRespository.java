package com.crud.PracticandoDWEC.persistence.repository;

import com.crud.PracticandoDWEC.dto.RestauranteDto;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRespository extends JpaRepository<Restaurante, Long> {

        Optional<Restaurante> findByNombre(String nombre);


}
