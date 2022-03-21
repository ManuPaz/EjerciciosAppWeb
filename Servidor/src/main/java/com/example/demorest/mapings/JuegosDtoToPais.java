package com.example.demorest.mapings;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Ciudad;
import com.example.demorest.entities.Pais;
import com.example.demorest.services.MappingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JuegosDtoToPais {
    @Autowired
    protected MappingService mappingService;
    @Mappings({ @Mapping(target="nombrepais", source="source.nombre_pais"),
            @Mapping(target="codigo_pais", source="source.codigoPais")})
    public abstract Pais juegodDtoToPais(JuegosDTO source);
}
