package com.example.demorest.dtos;

import lombok.Getter;
import lombok.Setter;

//clean code: anadir lombok
@Getter
@Setter
public class Sede {
    private String descripcion_tipo;
    private Integer ano;

    public Sede(String descripcionTipoJjoo, Integer año) {
        this.descripcion_tipo = descripcionTipoJjoo;
        this.ano = año;
    }
}
