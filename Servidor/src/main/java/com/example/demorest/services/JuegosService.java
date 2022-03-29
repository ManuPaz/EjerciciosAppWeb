package com.example.demorest.services;

import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.*;
import com.example.demorest.mapings.*;
import com.example.demorest.model.Sede;
import com.example.demorest.repositories.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;
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

/**
 * The type Juegos service.
 */
@Service
public class JuegosService {
    @Autowired
    private JuegosDtoToJuegosId juegosDtoToJuegosId;
    @Autowired
    private JuegosToJuegosDTO juegosToJuegosDTO;
    @Autowired
    private JuegosCiudadesToJJOO juegosCiudadesToJJOO;
    @Autowired
    private JuegosDtoToCiudad juegosDtoToCiudad;
    @Autowired
    private JuegosDtoToPais juegosDtoToPais;
    @Autowired
    private JuegosDtoToJuegos juegosDtoToJuegos;

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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<JJOO> findAll() {
        List<JuegosCiudades> juegos= juegosRepository.findJuegosCiudades();
        ArrayList<JJOO> juegosAux=new ArrayList<>();
        for (JuegosCiudades j:juegos){
            juegosAux.add(juegosCiudadesToJJOO.juegosToJJOO(j));
        }
        return juegosAux;
    }

    /**
     * Filtrar juegos list.
     *
     * @param parametro the parametro
     * @return the list
     */
    public List<JuegosCiudades> filtrarJuegos(String parametro) {
        Iterable<Pais> paises = paisRepository.findAll(QPais.pais.codigo_pais.eq("ES"));
        JPAQueryFactory queryFactory = new JPAQueryFactory(manager);
        QCiudad ciudad = QCiudad.ciudad;
        QPais pais = QPais.pais;
        QJuegos juegos = QJuegos.juegos;
        QTipoSede tiposede = QTipoSede.tipoSede;
        NumberPath<Long> count = Expressions.numberPath(Long.class, "c");
        boolean numeric = parametro.matches("-?\\d+(\\.\\d+)?");
        List<Tuple> juego;
        JPAQuery<Tuple> tupleJPAQuery = queryFactory.select(ciudad.id_ciudad, ciudad.nombreciudad, pais.id_pais, pais.nombrepais, Expressions.cases()
                        .when(ciudad.valor_ciudad.isNotNull()).then(ciudad.valor_ciudad)
                        .otherwise(pais.valor_pais), tiposede.descripciontipo, juegos.id.año.count()).
                from(ciudad).innerJoin(ciudad.pais, pais).leftJoin(ciudad.juegos, juegos).leftJoin(juegos.tipo_jjoo, tiposede);
        if (numeric) {
            Integer ano = Integer.parseInt(parametro);
            juego = tupleJPAQuery.where(juegos.id.año.eq(ano).or(ciudad.valor_ciudad.eq(ano).or(pais.valor_pais.eq(ano)))).
                    groupBy(ciudad, pais, tiposede).
                    fetch();
            List<Tuple> juego2 = queryFactory.select(ciudad.id_ciudad, ciudad.nombreciudad, pais.id_pais, pais.nombrepais, Expressions.cases()
                            .when(ciudad.valor_ciudad.isNotNull()).then(ciudad.valor_ciudad)
                            .otherwise(pais.valor_pais), tiposede.descripciontipo, juegos.id.año.count()).
                    from(ciudad).innerJoin(ciudad.pais, pais).leftJoin(ciudad.juegos, juegos).leftJoin(juegos.tipo_jjoo, tiposede).
                    groupBy(ciudad, pais, tiposede).having(juegos.id.año.count().eq(Long.valueOf(ano))).
                    fetch();

            juego.addAll(juego2);
        } else {

            juego = tupleJPAQuery.
                    where(ciudad.nombreciudad.eq(parametro).or(pais.nombrepais.eq(parametro)).or(tiposede.descripciontipo.eq(parametro))).
                    groupBy(ciudad, pais, tiposede).
                    fetch();
        }
        List<JuegosCiudades> juegosCiudades = new ArrayList<>();
        for (Tuple juegoAux : juego) {
            JuegosCiudades j = new JuegosCiudades(juegoAux.get(0, Integer.class), juegoAux.get(1, String.class), juegoAux.get(2, Integer.class), juegoAux.get(3, String.class),
                    juegoAux.get(4, Integer.class), juegoAux.get(6, Long.class), juegoAux.get(5, String.class));
            juegosCiudades.add(j);

        }
        return juegosCiudades;
    }

    /**
     * Find juegos ciudades list.
     *
     * @return the list
     */
    public List<JuegosCiudades> findJuegosCiudades() {
        return juegosRepository.findJuegosCiudades();
    }

    /**
     * Find juegos ciudad list.
     *
     * @param idciudad id de la ciudad de la que se buscan juego
     * @param tipo     tipo de juegos que se buscan INVIERNO
     *                 or VERANO
     * @return lista de dtos de sedes
     */
    public List<Sede> findJuegosCiudad(Integer idciudad, String tipo) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(tipo);
        Ciudad ciudad = null;
        if (tiposede != null) {
            return juegosRepository.findJuegosByCiudad(idciudad, tiposede.getId_tipo_jjoo());
        } else {
            return new ArrayList<>();
        }
    }

    private boolean guardarCiudad(JuegosDTO sede) {
        boolean finalizar = false;
        Ciudad ciudad;
        if (paisRepository.existsPaisByNombrepais(sede.getNombre_pais()) == false) {
            if (sede.getValor_pais() != null && sede.getNombre_pais() != null && sede.getCodigoPais() != null) {
                Pais pais = juegosDtoToPais.juegodDtoToPais(sede);
                paisRepository.save(pais);
            } else {
                finalizar = true;
            }
        }
        if (finalizar == false) {
            ciudad = juegosDtoToCiudad.juegodDtoToJuegosCiudad(sede);

            ciudadRepository.save(ciudad);
        }
        return finalizar;
    }

    /**
     * Guardar juegos .
     *
     * @param sede el dto con la sede que se quiere guardar (debe tener como minimo los atributos descripcion_tipo_jjoo y ano para poder guardarla)
     * @return entity Juegos con la nueva sede
     * @throws DataIntegrityViolationException
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Juegos guardarJuegos(JuegosDTO sede) {
        Juegos juegos = new Juegos();
        boolean finalizar = false;
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        if (tiposede != null) {
            if (!ciudadRepository.existsCiudadBynombreciudad(sede.getNombre_ciudad())) {
                finalizar = guardarCiudad(sede);
            }
        } else {
            finalizar = true;
        }
        if (finalizar == false) {
            juegos = juegosDtoToJuegos.juegodDtoToJuegos(sede);
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

    /**
     * Editar juegos .
     *
     * @param sede JuegosDto con la sede que se va a editar (debe tener como minimo los atributos descripcion_tipo_jjoo y ano)para poder editar)
     * @return entity Juegos con la sede modificada
     * @throws DataIntegrityViolationException
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Juegos editarJuegos(JuegosDTO sede) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        Juegos juegos1 = null;
        Juegos juegos2 = null;
        boolean finalizar = false;
        if (tiposede != null) {
            JuegosId id = juegosDtoToJuegosId.juegodDtoToJuegosId(sede);
            Optional<Juegos> juegos = juegosRepository.findById(id);
            if (juegos.isPresent()) {
                juegos1 = juegos.get();
                if (sede.getNuevoTipoSede() != null) {
                    if (tipoSedeRepository.existsTipoSedeBydescripciontipo(sede.getNuevoTipoSede())) {
                        if (!sede.getNuevoTipoSede().equals(sede.getDescripcion_tipo_jjoo())) {
                            sede.setDescripcion_tipo_jjoo(sede.getNuevoTipoSede());
                        }
                    } else {
                        finalizar = true;
                    }
                }
                if (finalizar == false) {
                    if (sede.getId_ciudad() != null) {
                        System.out.println(sede.getId_ciudad());
                        Optional<Ciudad> ciudad = ciudadRepository.findById(sede.getId_ciudad());
                        if (ciudad.isPresent()) {
                            Ciudad ciudad1 = ciudad.get();
                            juegos1.setCiudad(ciudad1);
                            sede.setNombre_ciudad(ciudad1.getNombreciudad());
                        } else {
                            finalizar = true;
                        }
                    } else if (sede.getNombre_ciudad() != null) {
                        Ciudad ciudad1 = ciudadRepository.findBynombreciudad(sede.getNombre_ciudad());
                        if (ciudad1 != null) {
                            juegos1.setCiudad(ciudad1);
                        } else {

                            finalizar = guardarCiudad(sede);
                            if (finalizar == false) {
                                ciudad1 = ciudadRepository.findBynombreciudad(sede.getNombre_ciudad());
                                sede.setId_ciudad(ciudad1.getId_ciudad());
                            }
                        }
                    } else {

                        sede.setNombre_ciudad(juegos1.getCiudad().getNombreciudad());
                    }
                }
                if (finalizar == false) {
                    if (sede.getNuevoAño() != null && sede.getNuevoAño().intValue() != sede.getAño().intValue()) {

                        sede.setAño(sede.getNuevoAño());
                    }
                }
            }
        } else {
            finalizar = true;
        }
        if (finalizar) {
            throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
        } else {
            juegosRepository.deleteById(juegos1.getId());
            juegos2 = juegosDtoToJuegos.juegodDtoToJuegos(sede);
            juegosRepository.save(juegos2);
        }

        return juegos2;
    }

    /**
     * Borrar juegos boolean.
     *
     * @param sede JuegdosDTO con la sede que se va a eliminar (solo tiene que tener cubiertos loa  atributos descripcion_tipo_jjoo y ano)
     * @return True si se ha eliminado la sede
     * or False si no se ha eliminado la sede
     */
    public boolean borrarJuegos(JuegosDTO sede) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(sede.getDescripcion_tipo_jjoo());
        if (tiposede != null) {
            JuegosId id = juegosDtoToJuegosId.juegodDtoToJuegosId(sede);
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


