package com.example.demorest.repositories;


import com.example.demorest.entities.Pais;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PaisRepository extends CrudRepository<Pais, Integer> {
    boolean existsPaisByNombrepais(String pais);

    Pais findPaisByNombrepais(String pais);
}
