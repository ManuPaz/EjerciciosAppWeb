package com.example.demorest.services;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.JJOO;
import com.example.demorest.repositories.JJOORepository;
import org.junit.jupiter.api.DisplayName;
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


    @DisplayName("Editar juegos")
    @ParameterizedTest(name = "Sede   a editar año:{2} ,tipo:{3}, nuevo nombre_ciudad:{1}")
    @CsvSource({"ESPAÑA,Madrid,1992,VERANO,2023,INVIERNO","ESPAÑA,Madrid,1924,INVIERNO,2023,VERANO"})
    public void editarJuegos(String nombre_pais,String nombre_ciudad,int año, String tipo, int nuevoAño,String nuevoTipo) {

        JuegosDTO sede = new JuegosDTO(nombre_pais,nombre_ciudad,null,null,tipo,año,nuevoAño,nuevoTipo,null);
        jjoo.editarJuegos(sede);
        List<JJOO> juegos = jjoo.findAll();
        ArrayList <String> nombres=new ArrayList<>();
        for (JJOO juego : juegos) {
            if (juego.getNombre_ciuddad()== nombre_ciudad) {

                assertEquals(1,juego.getNumero_veces_sede(), "Se esperaba 1 vez y se obtuvo " + juego.getNumero_veces_sede());
            }
            nombres.add(juego.getNombre_ciuddad());
        }
        assertTrue(nombres.contains(nombre_ciudad));



    }


}