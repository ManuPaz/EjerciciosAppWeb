package com.example.demorest.mapings;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Juegos;
import com.example.demorest.services.MappingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JuegosDtoToJuegos {
    @Autowired
    protected MappingService mappingService;
    @Autowired
    protected JuegosDtoToJuegosId juegosDtoToJuegosId;

    @Mappings({@Mapping(target = "ciudad", expression = "java(mappingService.findByNombreCiudad(source.getNombre_ciudad()))"),
            @Mapping(target = "tipo_jjoo", expression = "java(mappingService.findTipoSede(source))"),
            @Mapping(target = "id", expression = "java(juegosDtoToJuegosId.juegodDtoToJuegosId(source))")})
    public abstract Juegos juegodDtoToJuegos(JuegosDTO source);
}
