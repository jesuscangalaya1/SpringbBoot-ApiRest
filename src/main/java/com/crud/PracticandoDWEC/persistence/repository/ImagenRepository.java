package com.crud.PracticandoDWEC.persistence.repository;

import com.crud.PracticandoDWEC.persistence.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {

    List<Imagen> findByRestauranteId (Long restauranteID);
}
