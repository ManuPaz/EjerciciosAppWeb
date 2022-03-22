package com.example.demorest.repositories;

import com.example.demorest.entities.TipoSede;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TipoSedeRepository extends CrudRepository<TipoSede, Integer> {
    TipoSede findBydescripciontipo(String descripcion_tipo);
    boolean existsTipoSedeBydescripciontipo(String descripcion_tipo);
}