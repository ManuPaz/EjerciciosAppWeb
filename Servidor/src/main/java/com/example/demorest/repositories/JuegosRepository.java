package com.example.demorest.repositories;

import com.example.demorest.dtos.CiudadSede;
import com.example.demorest.dtos.Sede;
import com.example.demorest.entities.Juegos;
import com.example.demorest.entities.JuegosId;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

public interface JuegosRepository extends CrudRepository<Juegos, JuegosId> {
    @Transactional(readOnly = true)
    @Query(value = "select new com.example.demorest.dtos.CiudadSede(c.id_ciudad,c.nombreciudad, p.id_pais  , p" + ".nombrepais ," +
            " CASE WHEN c.valor_ciudad is NULL THEN p.valor_pais ELSE c.valor_ciudad  END ,  count(j.id" + ".año),t.descripciontipo) " +
            "from Ciudad c inner join c.pais as p left join c.juegos j  " + "left join j.tipo_jjoo  t group by c,p,t")
    List<CiudadSede> findCiudadSede();

    @Transactional(readOnly = true)
    @Query("Select new com.example.demorest.dtos.Sede(t.descripciontipo,j.id.año) from Ciudad c  inner join c.juegos j " +
            "inner join j.tipo_jjoo as t where c.id_ciudad= :id_ciudad and  j.id.tipo=:tipo_sede")
    List<Sede> findJuegosByCiudad(@Param("id_ciudad") int idCiudad, @Param("tipo_sede") Integer tipoSede);

}
