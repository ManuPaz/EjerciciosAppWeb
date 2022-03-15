package com.example.demorest.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class JJOO {


    private String nombre_pais;
    private String nombre_ciudad;
    private Integer id_pais;
    @Id
    private Integer id_ciudad;
    private Integer valor;
    private String descripcion_tipo_jjoo;
    private Integer numero_veces_sede;

    public JJOO(String nombre_pais, String nombre_ciudad, Integer id_pais, Integer id_ciudad, Integer valor, String descripcion_tipo_jjoo, Integer numero_veces_sede) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.id_ciudad = id_ciudad;
        this.valor = valor;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.numero_veces_sede = numero_veces_sede;
    }
}
