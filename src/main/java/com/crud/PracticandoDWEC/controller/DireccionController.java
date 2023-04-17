package com.crud.PracticandoDWEC.controller;

import com.crud.PracticandoDWEC.dto.DireccionDto;
import com.crud.PracticandoDWEC.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    @PostMapping("/restaurante/{restauranteId}/direccion")
    public ResponseEntity<DireccionDto> createDireccion(@PathVariable Long restauranteId, @RequestBody DireccionDto direccionDto){
        return new ResponseEntity<>(direccionService.createDireccion(restauranteId, direccionDto), HttpStatus.CREATED);
    }

    @PutMapping("/restaurante/{restauranteId}/direccion")
    public ResponseEntity<DireccionDto> updatedDirection(@PathVariable Long restauranteId,
                                                         @RequestBody DireccionDto direccionDto){

        DireccionDto direccionUpdated = direccionService.updateDireccion(restauranteId, direccionDto);
        return new ResponseEntity<>(direccionUpdated,HttpStatus.OK);
    }

    @GetMapping("/listDirections")
    public ResponseEntity<List<DireccionDto>> getAllDirections(){
        return new ResponseEntity<>(direccionService.getAllDirecciones(),HttpStatus.OK);
    }

    @GetMapping("/restaurante/{restauranteId}/direccion")
    public ResponseEntity<DireccionDto> getDirectionForRestaurantId (@PathVariable Long restauranteId){
        return new ResponseEntity<>(direccionService.getDirectionForRestaurante(restauranteId),HttpStatus.OK);
    }

    @DeleteMapping("/restaurant/{restauranteId}/direccion")
    public ResponseEntity<String> deleteDirectionForRestaurantId (@PathVariable Long restauranteId){
        direccionService.deleteDirection(restauranteId);
        return ResponseEntity.ok("La dirección para el restaurante con ID " + restauranteId + " se ha eliminado exitosamente.");
    }
}
