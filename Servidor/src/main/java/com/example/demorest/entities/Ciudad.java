package com.example.demorest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity

public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ciudad;
    private Integer valor_ciudad;
    @Column(name = "nombre_ciudad")
    private String nombreciudad;

    public List<Juegos> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juegos> juegos) {
        this.juegos = juegos;
    }

    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    private Pais pais;
    @JsonBackReference
    @OneToMany(mappedBy = "ciudad")

    private List<Juegos> juegos;


    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Integer getValor_ciudad() {
        return valor_ciudad;
    }

    public void setValor_ciudad(Integer valor_ciudad) {

        this.valor_ciudad = (valor_ciudad);
    }

    public String getNombreciudad() {
        return nombreciudad;
    }


    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }


}
