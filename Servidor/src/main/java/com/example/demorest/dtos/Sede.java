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



    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    private String descripcion_tipo_jjoo;
    private Integer año;


    public Sede( String descripcion_tipo_jjoo, Integer año) {

        this.descripcion_tipo_jjoo = descripcion_tipo_jjoo;

        this.año = año;
    }
}
