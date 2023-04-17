package com.crud.PracticandoDWEC.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String category;

    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "categoria")
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;


}
