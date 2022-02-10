package com.example.demorest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_jjoo")
public class TipoSede {


    public String getDescripciontipo() {
        return descripciontipo;
    }

    public void setDescripciontipo(String descripciontipo) {
        this.descripciontipo = descripciontipo;
    }


    public Integer getId_tipo_jjoo() {
        return id_tipo_jjoo;
    }

    public void setId_tipo_jjoo(Integer id_tipo_jjoo) {
        this.id_tipo_jjoo = id_tipo_jjoo;
    }

    @Id
    private Integer id_tipo_jjoo;
    @Column(name = "descripcion_tipo")
    private String descripciontipo;

}
