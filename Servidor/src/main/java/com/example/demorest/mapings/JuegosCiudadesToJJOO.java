package com.example.demorest.mapings;

import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.entities.JJOO;
import com.example.demorest.services.MappingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JuegosCiudadesToJJOO {
    @Autowired
    protected MappingService mappingService;
    public abstract JJOO juegosToJJOO(JuegosCiudades source );
}
