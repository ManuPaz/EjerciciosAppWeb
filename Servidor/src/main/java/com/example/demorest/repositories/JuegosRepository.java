package com.example.demorest.repositories;


import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.entities.Juegos;
import com.example.demorest.entities.JuegosId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JuegosRepository extends CrudRepository<Juegos, JuegosId> {

    @Transactional(readOnly = true)
    @Query(value = "select   new com.example.demorest.dtos.JuegosCiudades(c.id_ciudad,c.nombreciudad, p.id_pais  ,p.nombrepais , CASE WHEN c.valor_ciudad is NULL THEN p.valor_pais ELSE c.valor_ciudad  END , count(j.id.año),t.descripciontipo ,j.id.año) from " +
            "Ciudad c inner join c.pais as p left join c.juegos j left join j.tipo_jjoo  t group by c.id_ciudad,c.nombreciudad,p.id_pais,p.nombrepais,c.valor_ciudad,p.valor_pais,t.descripciontipo")
    List<JuegosCiudades> findJuegosCiudades();


}
