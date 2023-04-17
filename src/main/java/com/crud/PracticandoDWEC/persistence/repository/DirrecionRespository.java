package com.crud.PracticandoDWEC.persistence.repository;

import com.crud.PracticandoDWEC.persistence.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirrecionRespository extends JpaRepository<Direccion, Long> {
    Optional<Direccion> findByCalle(String calle);
    List<Direccion> findByRestauranteId (Long restauranteId);
    List<Direccion> findAll();
}
