package com.example.demorest.entities;

import com.example.demorest.anotaciones.Entidad;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entidad(obligatorio = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tipo_jjoo")
public class TipoSede {
    @Id
    private Integer id_tipo_jjoo;
    @Column(name = "descripcion_tipo")
    private String descripciontipo;

}
