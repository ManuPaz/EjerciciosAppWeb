package com.example.demorest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pais {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_pais;
    @Column(name="nombre_pais")
    private String nombrepais;
    private String codigo_pais;
    private Integer valor_pais;


}
