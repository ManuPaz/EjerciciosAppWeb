package com.example.demorest.dtos;


public class Sede {
    public Sede() {

    }

    public String getDescripcion_tipo_jjoo() {
        return descripcion_tipo_jjoo;
    }

    public void setDescripcion_tipo_jjoo(String descripcion_tipo_jjoo) {
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer año) {
        this.ano = año;
    }

    private String descripcion_tipo_jjoo;
    private Integer ano;

    public Sede(String descripcion_tipo_jjoo, Integer año) {
        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;
        this.ano = año;
    }
}
