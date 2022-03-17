package com.example.demorest.dtos;


public class JuegosCiudades {
    public JuegosCiudades() {

    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }


    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescripcion_tipo_jjoo() {
        return descripcion_tipo_jjoo;
    }

    public void setDescripcion_tipo_jjoo(String descripcion_tipo_jjoo) {
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
    }

    public Long getNumero_veces_sede() {
        return numero_veces_sede;
    }

    public void setNumero_veces_sede(Long numero_veces_sede) {
        this.numero_veces_sede = numero_veces_sede;
    }

    private String nombre_pais;
    private String nombre_ciudad;
    private Integer id_pais;
    private Integer año;

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }


    public void setAño(Integer año) {
        this.año = año;
    }

    private Integer id_ciudad;
    private Integer valor;
    private String descripcion_tipo_jjoo;
    private Long numero_veces_sede;

    public JuegosCiudades(Integer id_ciudad, String nombre_ciudad, Integer id_pais, String nombre_pais, Integer valor, Long numero_veces_sede, String descripcion_tipo_jjoo, Integer año) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.id_ciudad = id_ciudad;
        this.valor = valor;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.numero_veces_sede = numero_veces_sede;
        this.id_pais = id_pais;
        this.año = año;
    }

    public JuegosCiudades(Integer id_ciudad, String nombre_ciudad, Integer id_pais, String nombre_pais, Integer valor, Long numero_veces_sede, String descripcion_tipo_jjoo) {
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.id_ciudad = id_ciudad;
        this.valor = valor;
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.numero_veces_sede = numero_veces_sede;
        this.id_pais = id_pais;

    }
}
