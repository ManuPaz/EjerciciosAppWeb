package com.example.demorest.services;

import com.example.demorest.dtos.CiudadSede;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.*;
import com.example.demorest.mapings.*;
import com.example.demorest.model.Sede;
import com.example.demorest.repositories.CiudadRepository;
import com.example.demorest.repositories.JuegosRepository;
import com.example.demorest.repositories.PaisRepository;
import com.example.demorest.repositories.TipoSedeRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Juegos service.
 */
@Service
public class JuegosService {
    private static final  String THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK = "Throwing exception for demoing Rollback!!!";
    @Autowired
    private JuegosDtoToJuegosId juegosDtoToJuegosId;
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
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private PaisRepository paisRepository;



    /**
     * Filtrar juegos. Busca el match con un String o numero entero en todos los campos de la tabla de ciudades sede.
     *
     * @param parametro el String a buscar
     * @return lista de filas para la tabla de ciudades sede que hacen match para alcun campo
     */

    //clean code: eliminar variables no utilizadas
    //clean code: clonar tuplequery para reutilizarla
    public List<CiudadSede> filtrarJuegos(String parametro) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(manager);
        QCiudad ciudad = QCiudad.ciudad;
        QPais pais = QPais.pais;
        QJuegos juegos = QJuegos.juegos;
        QTipoSede tiposede = QTipoSede.tipoSede;
        boolean numeric = parametro.matches("-?\\d+(\\.\\d+)?");
        List<Tuple> juego;
        JPAQuery<Tuple> tupleJPAQuery = queryFactory.select(ciudad.id_ciudad, ciudad.nombreciudad, pais.id_pais,
                pais.nombrepais, Expressions.cases().when(ciudad.valor_ciudad.isNotNull()).then(ciudad.valor_ciudad).otherwise(pais.valor_pais),
                tiposede.descripciontipo, juegos.id.año.count()).from(ciudad).innerJoin(ciudad.pais, pais).leftJoin(ciudad.juegos, juegos).leftJoin(juegos.tipo_jjoo, tiposede);
        JPAQuery<Tuple> tupleJPAQuery2=tupleJPAQuery.clone();
        if (numeric) {
            Integer ano = Integer.parseInt(parametro);
            juego =
                    tupleJPAQuery.where(juegos.id.año.eq(ano).or(ciudad.valor_ciudad.eq(ano).or(pais.valor_pais.eq(ano)))).groupBy(ciudad, pais, tiposede).fetch();
            List<Tuple> juego2 =
                    tupleJPAQuery2 .groupBy(ciudad, pais, tiposede).having(juegos.id.año.count().eq(Long.valueOf(ano))).fetch();

            juego.addAll(juego2);
        } else {
            tupleJPAQuery.clone();
            juego = tupleJPAQuery.where(ciudad.nombreciudad.eq(parametro).or(pais.nombrepais.eq(parametro)).or(tiposede.descripciontipo.eq(parametro))).groupBy(ciudad, pais, tiposede).fetch();
        }
        List<CiudadSede> ciudadesSedes = new ArrayList<>();
        for (Tuple juegoAux : juego) {
            CiudadSede j = new CiudadSede(juegoAux.get(0, Integer.class), juegoAux.get(1, String.class),
                    juegoAux.get(2, Integer.class), juegoAux.get(3, String.class), juegoAux.get(4, Integer.class),
                    juegoAux.get(6, Long.class), juegoAux.get(5, String.class));
            ciudadesSedes.add(j);

        }
        return ciudadesSedes;
    }


    /**Devuelve todas las ciudades sede con el numero de veces que fueron sede
     * @return Lista con DTO CiudadSede
     */
    public List<CiudadSede> findAll() {

        return juegosRepository.findCiudadSede();
    }


    /**
     * Encuentra los juegos que tienen una determinada ciudad y de un tipo concreto, invierno o verao
     *
     * @param idciudad id de la ciudad de la que se buscan juego
     * @param tipo     tipo de juegos que se buscan INVIERNO
     *                 or VERANO
     * @return lista de dtos de sedes
     */

    public List<Sede> findJuegosCiudad(Integer idciudad, String tipo) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(tipo);
        if (tiposede != null) {
            return juegosRepository.findJuegosByCiudad(idciudad, tiposede.getId_tipo_jjoo());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Guardar una  nueva ciudad.
     * Si juegosDTO tiene en nombre de pais valido se guarda la nueva ciudad de ese pais.
     * Si juegosDTO no tiene un nombre de pais guardado pero tiene atributos de nombre de pais, codigo  de pais y
     * valor de pais se crea el nuevo pais y la nueva ciudad.
     * @param juegosDTO. DTO de juegos que incluye los atributos de ciudad y pais.
     */
    //clean code: modificar metodo para lanzar excepcion desde el metodo en vez de devolver boolean
    private void guardarCiudad(JuegosDTO juegosDTO) {


        if (!paisRepository.existsPaisByNombrepais(juegosDTO.getNombre_pais())) {
            if (juegosDTO.getValor_pais() != null  || juegosDTO.getNombre_pais() != null || juegosDTO.getCodigoPais() != null) {
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);

            }
            Pais pais = juegosDtoToPais.juegodDtoToPais(juegosDTO);
            paisRepository.save(pais);
        }

        Ciudad  ciudad = juegosDtoToCiudad.juegodDtoToJuegosCiudad(juegosDTO);
        ciudadRepository.save(ciudad);
    }

    /**
     * Guardar nuevos juegos. Guarda tambien la ciudad y el pais si no existen y se pasan los datos validos para
     * guardarlos. Si alguno de los atributos que se pasan es erroneo no se guardan los juegos.
     * Si juegosDTO tiene en nombre de pais valido se guarda la nueva ciudad de ese pais.
     * Si juegosDTO no tiene un nombre de pais guardado pero tiene atributos de nombre de pais, codigo  de pais y
     * valor de pais se crea el nuevo pais y la nueva ciudad.
     *
     * @param juegosDTO el dto con la sede que se quiere guardar (debe tener como minimo los atributos
     *                  descripcion_tipo_jjoo y ano para identificar la sede que se va a guardar, y  la ciudad donde
     *                  se realizan los juegos)
     * @return juegos con la nueva sede
     * @throws DataIntegrityViolationException
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    //clean code: modificar metodo para reducir complejidad
    public Juegos guardarJuegos(JuegosDTO juegosDTO) {

        Juegos juegos;
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(juegosDTO.getDescripcion_tipo_jjoo());
        if (tiposede==null)
            throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);

        if (!ciudadRepository.existsCiudadBynombreciudad(juegosDTO.getNombre_ciudad())) {
             guardarCiudad(juegosDTO);
        }
        juegos = juegosDtoToJuegos.juegodDtoToJuegos(juegosDTO);
        if (juegosRepository.existsById(juegos.getId()))
            throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);

        juegosRepository.save(juegos);
        return juegos;
    }

    /**
     * Editar juegos . Se puede editar la ciudad, año o tipo de la sede. Para editar la ciudad se puede utilizar el
     * nuevo id de ciudad o el nuevo nombre de ciudad. Si se usa el id de ciudad no se mira el nombre de ciudad.
     * Si alguno de los atributos que se pasan es erroneo no se modifican el resto de los atributos y se hace rollback.
     * Si la ciudad no existe y se puede crear igual que en el metodo guardarJuegos se crea.
     *
     * @param juegosDTO JuegosDto con la sede que se va a editar (debe tener como minimo los atributos
     *                  descripcion_tipo_jjoo y ano para identificar la sede que se va a editar)
     * @return entity Juegos con la sede modificada
     * @throws DataIntegrityViolationException
     */
    //clean code: eliminar boolean literals
    //clean code: comprobar nulls
    //clean code: modficar metodo para reducir compljidad cognitiva
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Juegos editarJuegos(JuegosDTO juegosDTO) {
        Juegos juegos;
        JuegosId id = juegosDtoToJuegosId.juegodDtoToJuegosId(juegosDTO);
        Optional<Juegos> juegosOptional = juegosRepository.findById(id);
        if (!juegosOptional.isPresent())
            throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
        juegos = juegosOptional.get();

        Ciudad ciudad;
        if (juegosDTO.getId_ciudad() != null){
            Optional<Ciudad> ciudadOptional = ciudadRepository.findById(juegosDTO.getId_ciudad());
            if (!ciudadOptional.isPresent())
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
            ciudad = ciudadOptional.get();
            juegosDTO.setNombre_ciudad(ciudad.getNombreciudad());

        }
        else if (juegosDTO.getNombre_ciudad() != null) {
             ciudad = ciudadRepository.findBynombreciudad(juegosDTO.getNombre_ciudad());
            if (ciudad != null) {
                juegosDTO.setId_ciudad(ciudad.getId_ciudad());
            } else {
                //si hay un datos de pais validos se puede anadir la nueva ciudad y usando el pais, o anadir el pais
                guardarCiudad(juegosDTO);
                ciudad = ciudadRepository.findBynombreciudad(juegosDTO.getNombre_ciudad());
                juegosDTO.setId_ciudad(ciudad.getId_ciudad());
            }

        }
        else
            juegosDTO.setNombre_ciudad(juegos.getCiudad().getNombreciudad());


        boolean cambiaId=false;
        if (juegosDTO.getNuevoTipoSede() != null && !juegosDTO.getNuevoTipoSede().equals(juegosDTO.getDescripcion_tipo_jjoo()) ) {
            if (!tipoSedeRepository.existsTipoSedeBydescripciontipo(juegosDTO.getNuevoTipoSede()))
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
            juegosDTO.setDescripcion_tipo_jjoo(juegosDTO.getNuevoTipoSede());
            cambiaId=true;
        }
        if ((juegosDTO.getNuevoAño() != null) && !juegosDTO.getNuevoAño().equals(juegosDTO.getAño())) {
            juegosDTO.setAño(juegosDTO.getNuevoAño());
            cambiaId=true;
        }
        //comprobacion de que no existe ya una sede de juegos con el id al que se quiere cambiar
        if (cambiaId){
            juegosOptional=juegosRepository.findById(juegosDtoToJuegosId.juegodDtoToJuegosId(juegosDTO));
            if (juegosOptional.isPresent())
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
            //si cambia el id tenemos que eliminar la entidad y volver a añadirla
            juegosRepository.deleteById(juegos.getId());


        }


        juegos = juegosDtoToJuegos.juegodDtoToJuegos(juegosDTO);
        juegosRepository.save(juegos);
        return juegos;
    }

    /**
     * Borrar juegos. Se debe pasar un DTO con  el ano y el tipo de sede para identificar la sede. El resto de
     * atributos del DTO no se miran.
     *
     * @param juegosDTO JuegdosDTO con la sede que se va a eliminar (solo tiene que tener cubiertos loa  atributos descripcion_tipo_jjoo y ano)
     * @return True si se ha eliminado la sede
     * or False si no se ha eliminado la sede
     */
    public boolean borrarJuegos(JuegosDTO juegosDTO) {
        TipoSede tiposede = tipoSedeRepository.findBydescripciontipo(juegosDTO.getDescripcion_tipo_jjoo());
        if (tiposede != null) {
            JuegosId id = juegosDtoToJuegosId.juegodDtoToJuegosId(juegosDTO);
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


