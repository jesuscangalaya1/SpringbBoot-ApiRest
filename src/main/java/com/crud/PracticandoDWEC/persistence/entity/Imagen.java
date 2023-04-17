package com.crud.PracticandoDWEC.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;
}
