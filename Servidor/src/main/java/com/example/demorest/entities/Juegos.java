package com.example.demorest.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "sede_jjoo")
public class Juegos {
    public Juegos() {

    }


    @EmbeddedId
    private JuegosId id;
    @JsonManagedReference

    @ManyToOne()
    //@JoinColumn(name = "sede", referencedColumnName = "id_ciudad")
    @JoinColumn(name = "sede", referencedColumnName = "id_ciudad")
    private Ciudad ciudad;


    public JuegosId getId() {
        return id;
    }


    public void setId(JuegosId id) {
        this.id = id;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }


    public TipoSede getTipo_jjoo() {
        return tipo_jjoo;
    }

    public void setTipo_jjoo(TipoSede tipo_jjoo) {
        this.tipo_jjoo = tipo_jjoo;
    }

    @ManyToOne
    @MapsId("tipo")
    @JoinColumn(name = "id_tipo_jjoo", referencedColumnName = "id_tipo_jjoo")
    private TipoSede tipo_jjoo;


}
