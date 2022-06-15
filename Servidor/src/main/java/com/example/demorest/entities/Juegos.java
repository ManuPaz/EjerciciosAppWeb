package com.example.demorest.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sede_jjoo")
public class Juegos {


    @EmbeddedId
    private JuegosId id;
    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "sede", referencedColumnName = "id_ciudad")
    private Ciudad ciudad;
    @ManyToOne
    @MapsId("tipo")
    @JoinColumn(name = "id_tipo_jjoo", referencedColumnName = "id_tipo_jjoo")
    private TipoSede tipo_jjoo;


}
