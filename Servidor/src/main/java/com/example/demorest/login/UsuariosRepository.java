package com.example.demorest.login;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UsuariosRepository extends ReactiveCrudRepository<Usuario, String> {
    Flux<Usuario> findByNombreAndPassword(String nombre, String password);

}
