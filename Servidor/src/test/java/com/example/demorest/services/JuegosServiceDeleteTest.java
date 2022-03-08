package com.example.demorest.services;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.JJOO;
import com.example.demorest.repositories.JJOORepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceDeleteTest {
    @Autowired
    JuegosService jjoo;
    @Autowired
    JJOORepository juegosRepository;


    @DisplayName("Eliminar juegos")
    @ParameterizedTest(name = "Sede   a eliminar año:{0} ,tipo:{1}, id_ciudad:{2}")
    @CsvSource({"1992,VERANO,3", "1924,INVIERNO,7"})
    public void eliminarJuegos(int año, String tipo, int id_ciudad) {

        JuegosDTO sede = new JuegosDTO(año, tipo);
        jjoo.borrarJuegos(sede);
        List<JJOO> juegos = jjoo.findAll();
        for (JJOO juego : juegos) {

            if (juego.getId_ciudad() == id_ciudad) {

                assertEquals(0,juego.getNumero_veces_sede(), "Se esperaba 0 veces y se obtuvo " + juego.getNumero_veces_sede());
            }
        }


    }


}