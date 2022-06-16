package com.example.demorest.login;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document("usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String password;

}
