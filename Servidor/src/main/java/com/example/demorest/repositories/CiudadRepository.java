package com.example.demorest.repositories;


import com.example.demorest.entities.Ciudad;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {
    boolean existsCiudadBynombreciudad(String nombre);

    Ciudad findBynombreciudad(String nombre);

}