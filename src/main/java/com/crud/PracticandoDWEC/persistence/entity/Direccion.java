package com.crud.PracticandoDWEC.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurante restaurante;


}
