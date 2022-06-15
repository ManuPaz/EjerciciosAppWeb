package com.example.demorest.dtos;

import lombok.Getter;
import lombok.Setter;

//clean code: añadir lombok
@Getter
@Setter
public class Sede {
    private String descripcion_tipo_jjoo;
    private Integer ano;

    public Sede(String descripcion_tipo_jjoo, Integer año) {
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.ano = año;
    }
}
