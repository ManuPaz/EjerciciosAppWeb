package com.example.demorest.dtos;

public class JuegosDTO {

    private String nombre_pais;
    private String nombre_ciudad;
    private String codigoPais;
    private Integer valor_ciudad;
    private Integer valor_pais;
    private String descripcion_tipo_jjoo;
    private Integer año;
    private Integer id_ciudad;
    private Integer id_pais;
    private Integer nuevoAño;
    private String nuevoTipoSede;

    public String getNuevoTipoSede() {
        return nuevoTipoSede;
    }

    public void setNuevoTipoSede(String nuevoTipoSede) {
        this.nuevoTipoSede = nuevoTipoSede;
    }


    public Integer getNuevoAño() {
        return nuevoAño;
    }

    public void setNuevoAño(Integer nuevoAño) {
        this.nuevoAño = nuevoAño;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public JuegosDTO(String nombre_pais, String nombre_ciudad, String codigoPais, Integer valor_ciudad, Integer valor_pais, String descripcion_tipo_jjoo, Integer año) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.codigoPais = codigoPais;
        this.valor_ciudad = valor_ciudad;
        this.valor_pais = valor_pais;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.año = año;
    }

    public JuegosDTO(Integer año, String tipo) {
        this.año = año;
        this.descripcion_tipo_jjoo = tipo;


    }

    public JuegosDTO(String nombre_pais, String nombre_ciudad, Integer idCiudad, String codigoPais, String descripcion_tipo_jjoo, Integer año, Integer nuevoAño, String nuevoTipoSede, Integer valorPais) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.codigoPais = codigoPais;
        this.id_ciudad = idCiudad;
        this.valor_pais = valorPais;

        this.nuevoAño = nuevoAño;
        this.valor_pais = valor_pais;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.año = año;
        this.nuevoTipoSede = nuevoTipoSede;
    }


    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Integer getValor_ciudad() {
        return valor_ciudad;
    }

    public void setValor_ciudad(Integer valor_ciudad) {
        this.valor_ciudad = valor_ciudad;
    }

    public Integer getValor_pais() {
        return valor_pais;
    }

    public void setValor_pais(Integer valor_pais) {
        this.valor_pais = valor_pais;
    }

    public String getDescripcion_tipo_jjoo() {
        return descripcion_tipo_jjoo;
    }

    public void setDescripcion_tipo_jjoo(String descripcion_tipo_jjoo) {
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }
}
