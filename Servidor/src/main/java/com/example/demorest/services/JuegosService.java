package com.example.demorest.services;

import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.dtos.Sede;
import com.example.demorest.entities.*;
import com.example.demorest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class JuegosService {

    @Autowired
    private JJOORepository jjooRepository;
    @Autowired
    private JuegosRepository juegosRepository;
    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private TipoSedeRepository tipoSedeRepository;
    @Autowired


    private PaisRepository paisRepository;


    //Incompatible types found: Iterable. Required: List
    public List<JJOO> findAll() {
        return jjooRepository.findAll();

    }

    public List<JuegosCiudades> findJuegosCiudades() {
        return juegosRepository.findJuegosCiudades();
    }
    public List<Sede> findJuegosCiudad(Integer idciudad, String tipo) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(tipo);
        Ciudad ciudad = null;
        if (tiposede != null) {


            return juegosRepository.findJuegosByCiudad(idciudad,tiposede.getId_tipo_jjoo());
        }
        else{

            return new ArrayList<>();
        }


    }

    private boolean guardarCiudad(JuegosDTO sede) {
        boolean finalizar = false;
        Ciudad ciudad;
        if (paisRepository.existsPaisByNombrepais(sede.getNombre_pais()) == false) {

            if (sede.getValor_pais() != null && sede.getNombre_pais() != null && sede.getCodigoPais() != null) {
                Pais pais = new Pais();
                pais.setCodigo_pais(sede.getCodigoPais());
                pais.setNombrepais(sede.getNombre_pais());
                pais.setValor_pais(sede.getValor_pais());
                paisRepository.save(pais);

            } else {
                finalizar = true;

            }


        }
        if (finalizar == false) {

            ciudad = new Ciudad();
            ciudad.setNombreciudad(sede.getNombre_ciudad());
            ciudad.setValor_ciudad(sede.getValor_ciudad());
            ciudad.setPais(paisRepository.findPaisByNombrepais(sede.getNombre_pais()));
            ciudadRepository.save(ciudad);


        }
        return finalizar;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Juegos guardarJuegos(JuegosDTO sede) {
        Juegos juegos = new Juegos();
        boolean finalizar = false;
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        Ciudad ciudad = null;
        if (tiposede != null) {

            if (ciudadRepository.existsCiudadBynombreciudad(sede.getNombre_ciudad())) {


                ciudad = ciudadRepository.findBynombreciudad(sede.getNombre_ciudad());


            } else {
                finalizar = guardarCiudad(sede);


            }


        } else {
            finalizar = true;
        }

        if (finalizar == false) {
            ciudad = ciudadRepository.findBynombreciudad(sede.getNombre_ciudad());
            juegos.setCiudad(ciudad);
            juegos.setTipo_jjoo(tiposede);
            JuegosId id = new JuegosId();
            id.setAño(sede.getAño());
            id.setTipo(tiposede.getId_tipo_jjoo());

            juegos.setId(id);
            if (juegosRepository.existsById(juegos.getId()) == false) {
                juegosRepository.save(juegos);
            } else {
                finalizar = true;
            }
        }

        if (finalizar) {
            throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");

        }
        return juegos;


    }

    public Juegos editarJuegos(JuegosDTO sede) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        Juegos juegos1 = null;
        Juegos juegos2 = null;
        boolean finalizar = false;
        if (tiposede != null) {
            JuegosId id = new JuegosId();
            id.setTipo(tiposede.getId_tipo_jjoo());
            id.setAño(sede.getAño());


            Optional<Juegos> juegos = juegosRepository.findById(id);

            if (juegos.isPresent()) {

                juegos1 = juegos.get();


                if (sede.getNuevoTipoSede() != null ) {

                    if (tipoSedeRepository.existsTipoSedeBydescripciontipo(sede.getNuevoTipoSede())){
                        if( !sede.getNuevoTipoSede().equals(sede.getDescripcion_tipo_jjoo()) ) {


                        TipoSede tiposede1 = tipoSedeRepository.findBydescripciontipo(sede.getNuevoTipoSede());
                        JuegosId id2 = new JuegosId();
                        id2.setAño(juegos1.getId().getAño());
                        id2.setTipo(tiposede1.getId_tipo_jjoo());
                        juegos2 = new Juegos();
                        juegos2.setId(id2);
                        juegos2.setCiudad(juegos1.getCiudad());
                        juegos2.setTipo_jjoo(tiposede1);
                        juegosRepository.save(juegos2);
                        juegosRepository.deleteById(juegos1.getId());

                    }}else{
                        finalizar=true;
                    }
                }
                if (juegos2 != null) {
                    juegos1 = juegos2;
                    juegos2=null;
                }
                if (finalizar == false) {
                    if (sede.getId_ciudad() != null) {

                        Optional<Ciudad> ciudad = ciudadRepository.findById(sede.getId_ciudad());
                        if (ciudad.isPresent()) {
                            Ciudad ciudad1 = ciudad.get();
                            juegos1.setCiudad(ciudad1);
                        } else {
                            finalizar = true;
                        }


                    } else {
                        if (sede.getNombre_ciudad() != null) {

                            Ciudad ciudad1 = ciudadRepository.findBynombreciudad(sede.getNombre_ciudad());

                            if (ciudad1 != null) {

                                juegos1.setCiudad(ciudad1);
                            } else {
                                finalizar = guardarCiudad(sede);
                                if (finalizar==false){
                                    ciudad1 = ciudadRepository.findBynombreciudad(sede.getNombre_ciudad());
                                    juegos1.setCiudad(ciudad1);
                                }
                            }


                        }
                    }
                }
                if (finalizar == false) {
                    juegosRepository.save(juegos1);


                    if (sede.getNuevoAño() != null && sede.getNuevoAño().intValue() != sede.getAño().intValue()) {
                        Juegos j;
                        if (juegos2 != null) {
                            j = juegos2;

                        } else {

                            j = juegos1;


                        }

                        JuegosId id2 = new JuegosId();
                        id2.setAño(sede.getNuevoAño());
                        id2.setTipo(j.getId().getTipo());

                        juegos2 = new Juegos();
                        juegos2.setId(id2);
                        juegos2.setCiudad(j.getCiudad());
                        juegos2.setTipo_jjoo(j.getTipo_jjoo());
                        juegosRepository.save(juegos2);
                        juegosRepository.deleteById(j.getId());
                        return juegos2;


                    }
                }


            }
        } else {
            finalizar = true;
        }
        if (finalizar) {
            throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");

        }

        if (juegos2 != null) juegos1 = juegos2;
        return juegos1;


    }

    public boolean borrarJuegos(JuegosDTO sede) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        if (tiposede != null) {
            JuegosId id = new JuegosId();
            id.setTipo(tiposede.getId_tipo_jjoo());
            id.setAño(sede.getAño());

            if (juegosRepository.existsById(id)) {
                juegosRepository.deleteById(id);
                return true;
            } else {
                return false;
            }

        }
        return false;
    }


}
