package com.example.demorest.entities;


import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class JJOO {
    public JJOO() {
        
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getNombre_ciuddad() {
        return nombre_ciudad;
    }

    public void setNombre_ciuddad(String nombre_ciuddad) {
        this.nombre_ciudad = nombre_ciuddad;
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

    public Integer getNumero_veces_sede() {
        return numero_veces_sede;
    }

    public void setNumero_veces_sede(Integer numero_veces_sede) {
        this.numero_veces_sede = numero_veces_sede;
    }

    private String nombre_pais;
    private String nombre_ciudad;
    private Integer  id_pais;






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
