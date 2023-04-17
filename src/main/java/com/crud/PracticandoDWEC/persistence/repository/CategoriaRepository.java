package com.crud.PracticandoDWEC.persistence.repository;

import com.crud.PracticandoDWEC.persistence.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByCategory(String category);
    List<Categoria> findByRestauranteId(Long restauranteId);
}
