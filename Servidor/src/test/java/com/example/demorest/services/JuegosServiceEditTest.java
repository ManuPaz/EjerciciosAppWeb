package com.example.demorest.services;
import com.example.demorest.dtos.CiudadSede;
import com.example.demorest.dtos.JuegosDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceEditTest {
    @Autowired
    JuegosService jjoo;
    private ArrayList<JuegosDTO> sedes;

    @BeforeEach
    public void init() {
        this.sedes = new ArrayList();

        JuegosDTO sede1 = new JuegosDTO("ESPAÑA", "Madrid", null, null, "VERANO", 1992, 2023, "INVIERNO", null);
        sedes.add(sede1);
        sede1 = new JuegosDTO("ESPAÑA", "Madrid", null, null, "INVIERNO", 1924, 2023, "VERANO", null);
        sedes.add(sede1);


    }

    @DisplayName("Editar juegos")
    @Test
    public void editarJuegos() {

        for (JuegosDTO sede : sedes) {
            jjoo.editarJuegos(sede);
            List<CiudadSede> juegos = jjoo.findAll();
            ArrayList<String> nombres = new ArrayList<>();
            String nombre_ciudad = sede.getNombre_ciudad();
            for (CiudadSede juego : juegos) {
                if (juego.getNombre_ciudad() == nombre_ciudad) {
                    assertEquals(1, juego.getNumero_veces_sede(),
                            "Se esperaba 1 vez y se obtuvo " + juego.getNumero_veces_sede());
                }
                nombres.add(juego.getNombre_ciudad());
            }
            assertTrue(nombres.contains(nombre_ciudad));
        }


    }


}