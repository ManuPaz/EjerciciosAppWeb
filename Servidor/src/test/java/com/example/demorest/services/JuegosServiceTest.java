package com.example.demorest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import com.example.demorest.dtos.CiudadSede;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.HashMap;
import java.util.List;


@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceTest {
    @Autowired
    JuegosService jjoo;

    @Test
    @DisplayName("Atributo valor no nulo")
    public void checknotnull() {
        List<CiudadSede> juegos = jjoo.findAll();
        assertThat(juegos).isNotEmpty().allMatch(juego -> juego.getValor() != null);
    }

    @DisplayName("Numero de juegos totales")
    @ParameterizedTest(name = "Numero de juegos totales")
    @CsvSource({"12"})
     void numeroDeJuegos(int numeroDeJuegos) {
        List<CiudadSede> juegos = jjoo.findAll();
        assertEquals((Integer) juegos.size(), (Integer) numeroDeJuegos);
    }

    @DisplayName("Test de numero de veces sede")
    @ParameterizedTest(name = "Numero de veces por juego de ciudad con id:{0}")
    @CsvSource({"3,1", "4,0", "8,2", "7,1"})
     void numeroVeces(int id, long numveces) {
        HashMap<Integer, Integer> ciudades = new HashMap<>();
        List<CiudadSede> juegos = jjoo.findAll();
        for (CiudadSede juego : juegos) {
            if (juego.getId_ciudad() == id) {
                assertEquals(juego.getNumero_veces_sede(), (Long) numveces);
                break;
            }
        }
    }
}