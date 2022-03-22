package com.example.demorest.services;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.JJOO;
import com.example.demorest.repositories.JJOORepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceDeleteTest {
    @Autowired
    JuegosService jjoo;
    @Autowired
    JJOORepository juegosRepository;
    private ArrayList<JuegosDTO> sedes;
    private ArrayList<Integer> ciudades;

    @BeforeEach
    public void init() {
        this.sedes = new ArrayList();
        this.ciudades = new ArrayList();
        JuegosDTO sede1 = new JuegosDTO(1992, "VERANO");
        sedes.add(sede1);
        sede1 = new JuegosDTO(1924, "INVIERNO");
        sedes.add(sede1);
        ciudades.add(3);
        ciudades.add(7);


    }

    @DisplayName("Eliminar juegos")
    @Test
    public void eliminarJuegos() {
        for (int i = 0; i < ciudades.size(); i++) {
            JuegosDTO sede = sedes.get(i);
            int ciudad = ciudades.get(i);
            jjoo.borrarJuegos(sede);
            List<JJOO> juegos = jjoo.findAll();
            for (JJOO juego : juegos) {
                if (juego.getId_ciudad() == ciudad) {
                    assertEquals(0, juego.getNumero_veces_sede(), "Se esperaba 0 veces y se obtuvo " + juego.getNumero_veces_sede());
                }
            }
        }

    }


}