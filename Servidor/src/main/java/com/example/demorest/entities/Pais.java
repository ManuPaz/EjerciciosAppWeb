package com.example.demorest.entities;

import javax.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_pais;
    @Column(name="nombre_pais")
    private String nombrepais;
    private String codigo_pais;
    private Integer valor_pais;

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public Integer getValor_pais() {
        return valor_pais;
    }

    public void setValor_pais(Integer valor_pais) {
        this.valor_pais = valor_pais;
    }
}
