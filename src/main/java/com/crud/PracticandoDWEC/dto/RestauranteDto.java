package com.crud.PracticandoDWEC.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

}
