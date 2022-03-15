package com.example.demorest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @OneToMany(mappedBy = "ciudad") private List<Juegos> juegos;




}
