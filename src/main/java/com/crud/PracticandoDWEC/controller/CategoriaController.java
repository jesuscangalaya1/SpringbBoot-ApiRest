package com.crud.PracticandoDWEC.controller;

import com.crud.PracticandoDWEC.dto.CategoriaDto;
import com.crud.PracticandoDWEC.persistence.entity.Categoria;
import com.crud.PracticandoDWEC.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/restaurants/{restauranteId}/categorias")
    public ResponseEntity<List<CategoriaDto>> listAllCategory (@PathVariable Long restauranteId){
        return new ResponseEntity<>(categoriaService.getCategoryForRestaurantById(restauranteId),HttpStatus.OK);
    }

    @GetMapping("/restaurants/{restauranteId}/categorias/{id}")
    public ResponseEntity<Categoria> getCategoryForId (@PathVariable Long restauranteId, @PathVariable Long id){
        Categoria categoriaDto = categoriaService.getCategoryById(restauranteId, id);
        return new ResponseEntity<>(categoriaDto, HttpStatus.OK);
    }


    @PostMapping("/restaurant/{restauranteId}/categoria")
    public ResponseEntity<CategoriaDto> createCategoria(@PathVariable Long restauranteId, @RequestBody CategoriaDto categoriaDto) {
        return new ResponseEntity<>(categoriaService.createCategoria(restauranteId, categoriaDto), HttpStatus.CREATED);
    }

    @PutMapping("/restaurant/{restauranteId}/categorias/{id}")
    public ResponseEntity<CategoriaDto> updatedCategory(@PathVariable Long restauranteId,
                                                        @PathVariable Long id,
                                                        @RequestBody CategoriaDto categoriaDto) {

        CategoriaDto updatedCategory = categoriaService.updateCategoria(restauranteId, id, categoriaDto);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/restaurante/{restauranteId}/categorias/{id}")
    public ResponseEntity<String> deleteCategory (@PathVariable Long restauranteId, @PathVariable Long id){
        categoriaService.deleteCategoria(restauranteId, id);
        return new ResponseEntity<>("Eliminado !!", HttpStatus.OK);
    }


}
