package com.example.demorest.services;

import com.example.demorest.anotaciones.Validador;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Ciudad;
import com.example.demorest.entities.Pais;
import com.example.demorest.entities.TipoSede;
import com.example.demorest.repositories.CiudadRepository;
import com.example.demorest.repositories.JuegosRepository;
import com.example.demorest.repositories.PaisRepository;
import com.example.demorest.repositories.TipoSedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class MappingService {

    @Autowired
    private CiudadRepository ciudadRepository;
    @Autowired
    private TipoSedeRepository tipoSedeRepository;
    @Autowired
    private PaisRepository paisRepository;

    public Integer findIdTipoSede(String id) {
        Optional<TipoSede> tiposedeOptional = tipoSedeRepository.findBydescripciontipo(id);
        TipoSede tiposede = (TipoSede) Validador.procesarOptional(tiposedeOptional,TipoSede.class);
        return tiposede.getId_tipo_jjoo();
    }

    public Pais findByNombrePais(String nombre) {
        return paisRepository.findPaisByNombrepais(nombre);
    }

    public Ciudad findByNombreCiudad(String nombre) {
        return ciudadRepository.findBynombreciudad(nombre).get();
    }

    public TipoSede findTipoSede(JuegosDTO sede) {
        Optional<TipoSede> tiposedeOptional = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        return (TipoSede) Validador.procesarOptional(tiposedeOptional,TipoSede.class);
    }

}



