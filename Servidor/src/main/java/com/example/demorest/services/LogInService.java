package com.example.demorest.services;

import com.example.demorest.login.Usuario;
import com.example.demorest.login.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LogInService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    /**
     * Check login boolean.
     *
     * @param nombre   el nombre
     * @param password la contrasena
     * @return True si los credenciales son correctos
     */
    public boolean checkLogin(String nombre, String password) {
        Flux<Usuario> usuarioFlux = usuariosRepository.findByNombreAndPassword(nombre, password);
        Mono<Long> numero = usuarioFlux.count();
        Long num = numero.block();
        return num > 0;
    }


}
