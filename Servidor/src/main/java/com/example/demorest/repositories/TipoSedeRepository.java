package com.example.demorest.repositories;

import com.example.demorest.entities.TipoSede;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TipoSedeRepository extends CrudRepository<TipoSede, Integer> {
    Optional<TipoSede> findBydescripciontipo(String descripcionTipo);

    boolean existsTipoSedeBydescripciontipo(String descripcionTipo);
}