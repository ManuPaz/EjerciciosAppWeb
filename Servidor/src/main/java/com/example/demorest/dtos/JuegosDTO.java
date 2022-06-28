package com.example.demorest.dtos;

import com.example.demorest.anotaciones.Estacion;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//clean code: anadir lombok
@Getter
@Setter
public class JuegosDTO {
    private String nombre_pais;
    private String nombre_ciudad;
    private String codigoPais;
    private Integer valor_ciudad;
    private Integer valor_pais;
    @Estacion(notNull = true)
    private String descripcion_tipo_jjoo;
    @Min(value = 1000, message = "El año debe ser mayor que 1000")
    private Integer ano;
    private Integer id_ciudad;
    private Integer id_tipo_jjoo;
    private Integer id_pais;
    @Min(value = 1000, message = "El año debe ser mayor que 1000")
    @Max(value = 10000, message = "El año debe ser menor que 2050")
    private Integer nuevoAño;
    @Estacion(notNull = false)
    private String nuevoTipoSede;

    public JuegosDTO() {
    }

    public JuegosDTO(String nombre_pais, String nombre_ciudad, String codigoPais, Integer valor_ciudad, Integer valor_pais, String descripcion_tipo_jjoo, Integer ano) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.codigoPais = codigoPais;
        this.valor_ciudad = valor_ciudad;
        this.valor_pais = valor_pais;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.ano = ano;
    }

    public JuegosDTO(Integer año, String tipo) {
        this.ano = año;
        this.descripcion_tipo_jjoo = tipo;
    }

    public JuegosDTO(String nombre_pais, String nombre_ciudad, Integer idCiudad, String codigoPais, String descripcion_tipo_jjoo, Integer ano, Integer nuevoAño, String nuevoTipoSede, Integer valorPais) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.codigoPais = codigoPais;
        this.id_ciudad = idCiudad;
        this.valor_pais = valorPais;
        this.nuevoAño = nuevoAño;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.ano = ano;
        this.nuevoTipoSede = nuevoTipoSede;
    }
}
