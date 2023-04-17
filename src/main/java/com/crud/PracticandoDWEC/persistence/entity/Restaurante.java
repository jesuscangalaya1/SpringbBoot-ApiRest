package com.crud.PracticandoDWEC.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name ="categoria_id")
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "restaurante", orphanRemoval = true)
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante", orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurante")
    private Direccion direcciones;

}
