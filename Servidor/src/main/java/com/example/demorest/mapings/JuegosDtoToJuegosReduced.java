package com.example.demorest.mapings;

import com.example.demorest.dtos.*;
import com.example.demorest.entities.Juegos;
import com.example.demorest.entities.Ciudad;
import com.example.demorest.entities.TipoSede;
import com.example.demorest.entities.JuegosId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class JuegosDtoToJuegosReduced {
    @Mappings({@Mapping(target = "ciudad", expression = "java(new com.example.demorest.entities.Ciudad(source.getId_ciudad()))"),
            @Mapping(target = "tipo_jjoo", expression = "java(new com.example.demorest.entities.TipoSede(source.getId_tipo_jjoo()))"),
            @Mapping(target = "id", expression = "java(new com.example.demorest.entities.JuegosId(source.getAno(),source.getId_tipo_jjoo()))")})
    public abstract Juegos juegodDtoToPais(JuegosDTO source);

    public abstract List<Juegos> juegodDtoListToJuegosReducedList(List<JuegosDTO> dtos);
}
