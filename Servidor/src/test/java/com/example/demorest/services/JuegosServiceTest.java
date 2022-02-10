package com.example.demorest.services;

import com.example.demorest.entities.JJOO;
import com.example.demorest.repositories.JJOORepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.intValue;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JuegosServiceTest {
    @Autowired
    JuegosService jjoo;
    @Autowired
    JJOORepository juegosRepository;
    @Test
    @DisplayName("Test valor not null")
    public void checknotnull() {
        List<JJOO> juegos =  jjoo.findAll();

        assertThat(juegos)
                .isNotEmpty()
                .allMatch(juego -> juego.getValor()!=null);
    }
    //select count(sede),sede from  sede_jjoo group by sede;
    @Test
    @DisplayName("Test del numero de veces")
    public void numeroVeces(){
        HashMap<Integer,Integer> ciudades=new HashMap<>();
        ciudades.put(3,1);
        ciudades.put(4,0);
        ciudades.put(8,2);
        ciudades.put(7,1);
        List<JJOO> juegos =  jjoo.findAll();
        for (JJOO juego : juegos){

            if (ciudades.containsKey(juego.getId_ciudad())){

            assertEquals((Integer)juego.getNumero_veces_sede(),(Integer)ciudades.get(juego.getId_ciudad()));}


        }
    }



}