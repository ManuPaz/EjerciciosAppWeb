package com.example.demorest.services;

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

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceTest {
    @Autowired
    JuegosService jjoo;
    @Autowired
    JJOORepository juegosRepository;

    @Test
    @DisplayName("Atributo valor no nulo")
    public void checknotnull() {
        List<JJOO> juegos = jjoo.findAll();

        assertThat(juegos)
                .isNotEmpty()
                .allMatch(juego -> juego.getValor() != null);
    }

    //select count(sede),sede from  sede_jjoo group by sede;
    @DisplayName("Numero de juegos totales")
    @ParameterizedTest(name="Numero de juegos totales")
    @CsvSource({"12"})
    public void numeroDeJuegos(int numeroDeJuegos) {

        List<JJOO> juegos = jjoo.findAll();

        assertEquals((Integer) juegos.size(), (Integer) numeroDeJuegos);
    }

    @DisplayName("Test de numero de veces sede")
    @ParameterizedTest(name = "Numero de veces por juego de ciudad con id:{0}")
    @CsvSource({"3,1", "4,0", "8,2", "7,1"})
    public void numeroVeces(int id, int numveces) {
        HashMap<Integer, Integer> ciudades = new HashMap<>();

        List<JJOO> juegos = jjoo.findAll();
        for (JJOO juego : juegos) {
            if (juego.getId_ciudad() == id) {
                assertEquals((Integer) juego.getNumero_veces_sede(), (Integer) numveces);
                break;
            }
        }


    }


}