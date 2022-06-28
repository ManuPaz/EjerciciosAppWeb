package com.example.demorest.mapings;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Juegos;
import com.example.demorest.services.MappingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JuegosToJuegosDTO {
    @Autowired
    protected MappingService mappingService;

    @Mappings({@Mapping(target = "nombre_pais", source = "source.ciudad.pais.nombrepais"),
            @Mapping(target = "nombre_ciudad", source = "source.ciudad.nombreciudad"),
            @Mapping(target = "codigoPais", source = "source.ciudad.pais.codigo_pais"),
            @Mapping(target = "descripcion_tipo_jjoo", source = "source.tipo_jjoo.descripciontipo"),
            @Mapping(target = "ano", source = "source.id.año"),
    })
    public abstract JuegosDTO juegosToJuegosDTO(Juegos source);

}
