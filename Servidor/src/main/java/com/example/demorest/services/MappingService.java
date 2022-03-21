package com.example.demorest.services;
import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.*;
import com.example.demorest.mapings.JuegosDtoToJuegosId;
import com.example.demorest.model.Sede;
import com.example.demorest.repositories.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class MappingService {

    @Autowired
    private JJOORepository jjooRepository;
    @Autowired
    private JuegosRepository juegosRepository;
    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private TipoSedeRepository tipoSedeRepository;
    @Autowired
    private EntityManager manager;

    @Autowired
    private PaisRepository paisRepository;




    public Integer findIdTipoSede(String id){
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(id);
        return tiposede.getId_tipo_jjoo();
    }
    public Pais findByNombrePais(String nombre){

        return paisRepository.findPaisByNombrepais(nombre);
    }
    public Ciudad findByNombreCiudad(String nombre){

        return ciudadRepository.findBynombreciudad(nombre);
    }
    public TipoSede findTipoSede(JuegosDTO sede){
        return tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
    }

}



