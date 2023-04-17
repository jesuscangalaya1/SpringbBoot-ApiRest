package com.crud.PracticandoDWEC.controller;

import com.crud.PracticandoDWEC.dto.RestauranteDto;
import com.crud.PracticandoDWEC.persistence.entity.Restaurante;
import com.crud.PracticandoDWEC.service.RestauranteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    @PostMapping("/create")
    public ResponseEntity<RestauranteDto> createRestaurant(@RequestBody RestauranteDto restauranteDto) {
        return new ResponseEntity<>(restauranteService.createRestaurant(restauranteDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDto> updateRestaurant(@PathVariable Long id, @RequestBody RestauranteDto restauranteDto) {
        RestauranteDto restaurantRequest = restauranteService.updateRestaurant(restauranteDto, id);
        return new ResponseEntity<>(restaurantRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
        return new ResponseEntity<>("Restaurant eliminado", HttpStatus.OK);
    }

    @GetMapping("/listForId/{id}")
    public ResponseEntity<Restaurante> getRestaurantById(@PathVariable Long id) {
        return new ResponseEntity<>(restauranteService.getRestaurantId(id), HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Restaurante>> listRestaurant() {
        return new ResponseEntity<>(restauranteService.list(), HttpStatus.OK);
    }
}
