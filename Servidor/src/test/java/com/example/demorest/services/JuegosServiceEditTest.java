package com.example.demorest.services;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.JJOO;
import com.example.demorest.repositories.JJOORepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceEditTest {
    @Autowired
    JuegosService jjoo;
    @Autowired
    JJOORepository juegosRepository;
    private  ArrayList<JuegosDTO> sedes;
    @BeforeEach
    public void init() {
        this.sedes=new ArrayList();

        JuegosDTO sede1 = new JuegosDTO("ESPAÑA","Madrid",null,null,"VERANO",1992,2023,"INVIERNO",null);
        sedes.add(sede1);
        sede1 = new JuegosDTO("ESPAÑA","Madrid",null,null,"INVIERNO",1924,2023,"VERANO",null);
        sedes.add(sede1);



    }

    @DisplayName("Editar juegos")
    @Test
    public void editarJuegos() {

        for (JuegosDTO sede: sedes) {
            jjoo.editarJuegos(sede);
            List<JJOO> juegos = jjoo.findAll();
            ArrayList<String> nombres = new ArrayList<>();
            String nombre_ciudad=sede.getNombre_ciudad();
            for (JJOO juego : juegos) {
                if (juego.getNombre_ciuddad() == nombre_ciudad) {

                    assertEquals(1, juego.getNumero_veces_sede(), "Se esperaba 1 vez y se obtuvo " + juego.getNumero_veces_sede());
                }
                nombres.add(juego.getNombre_ciuddad());
            }
            assertTrue(nombres.contains(nombre_ciudad));
        }


    }


}