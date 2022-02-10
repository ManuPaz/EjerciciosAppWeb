package com.example.demorest.repositories;


import com.example.demorest.entities.JJOO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface JJOORepository extends CrudRepository<JJOO, Integer> {
    @Transactional
    @Query(value="select id_ciudad,nombre_ciudad, ciudad.id_pais as id_pais,nombre_pais, CASE WHEN valor_ciudad is NULL THEN valor_pais ELSE valor_ciudad  END AS valor, count(año)as  numero_veces_sede,descripcion_tipo as descripcion_tipo_jjoo from \n" +
            "ciudad inner join pais on ciudad. id_pais= pais.id_pais left join sede_jjoo on sede_jjoo.sede=ciudad.id_ciudad  left join  tipo_jjoo on  tipo_jjoo. id_tipo_jjoo=sede_jjoo.id_tipo_jjoo group by id_ciudad,nombre_ciudad,ciudad.id_pais,nombre_pais,valor_ciudad,valor_pais,descripcion_tipo;",nativeQuery = true)
    List<JJOO> findAll();

}
