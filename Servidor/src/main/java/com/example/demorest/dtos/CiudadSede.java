package com.example.demorest.dtos;

import lombok.Getter;
import lombok.Setter;
//clean code: anadir lombok
//clean code: renombrar
@Getter
@Setter
public class CiudadSede {
    private String nombre_pais;
    private String nombre_ciudad;
    private Integer id_pais;
    private Integer id_ciudad;
    private Integer valor;
    private String descripcion_tipo_jjoo;
    private Long numero_veces_sede;

    public CiudadSede(Integer id_ciudad, String nombre_ciudad, Integer id_pais, String nombre_pais, Integer valor, Long numero_veces_sede, String descripcion_tipo_jjoo) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.id_ciudad = id_ciudad;
        this.valor = valor;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.numero_veces_sede = numero_veces_sede;
        this.id_pais = id_pais;
    }





}
