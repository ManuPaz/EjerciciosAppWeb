package com.example.demorest.mapings;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Ciudad;
import com.example.demorest.services.MappingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JuegosDtoToCiudad {
    @Autowired
    protected MappingService mappingService;

    @Mappings({@Mapping(target = "nombreciudad", source = "source.nombre_ciudad"),
            @Mapping(target = "pais", expression = "java(mappingService.findByNombrePais(source.getNombre_pais()))")})
    public abstract Ciudad juegodDtoToJuegosCiudad(JuegosDTO source);
}
