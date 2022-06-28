package com.example.demorest.entities;

import com.example.demorest.anotaciones.Entidad;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entidad(obligatorio = true)
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
    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    private Pais pais;
    @JsonBackReference
    @OneToMany(mappedBy = "ciudad")
    private List<Juegos> juegos;

    public Ciudad(int id_ciudad){
        this.id_ciudad=id_ciudad;
    }
}
