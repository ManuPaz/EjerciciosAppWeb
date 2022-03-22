package com.example.demorest.mapings;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.JuegosId;
import com.example.demorest.services.MappingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JuegosDtoToJuegosId {
    @Autowired
    protected MappingService mappingService;

    @Mappings({
            @Mapping(target = "tipo", expression = "java(mappingService.findIdTipoSede(source.getDescripcion_tipo_jjoo()))")})
    public abstract JuegosId juegodDtoToJuegosId(JuegosDTO source);
}
