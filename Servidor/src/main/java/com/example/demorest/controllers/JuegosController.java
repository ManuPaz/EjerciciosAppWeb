package com.example.demorest.controllers;

import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.dtos.Sede;
import com.example.demorest.entities.Juegos;
import com.example.demorest.services.JuegosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
public class JuegosController {

    @Autowired
    JuegosService juegosService;


    /*@GetMapping("/juegos")
    public ResponseEntity<List<JJOO>> juego() {

        return new ResponseEntity<List<JJOO>>(juegosService.findAll(), HttpStatus.OK);
    }*/

    @GetMapping("/juegos")
    public ResponseEntity<List<JuegosCiudades>> juego1() {

        return new ResponseEntity<List<JuegosCiudades>>(juegosService.findJuegosCiudades(), HttpStatus.OK);
    }

    @GetMapping("/juegos/ciudad")
    ResponseEntity<List<Sede>> buscarJuegosPorCiudad(




            @RequestParam(value = "ciudad", required = true) Integer ciudad,
            @RequestParam(value = "tipo", required = true) String tipo


    ) {

        HttpStatus codigo = HttpStatus.OK;

       List<Sede> j=juegosService.findJuegosCiudad(ciudad,tipo);

       return new ResponseEntity<List<Sede>>(j, codigo);




    }
    @PostMapping("/juegos/anadir")
    ResponseEntity<Juegos> newJuegos(@RequestParam(value = "ciudad", required = true) String nombre_ciudad,
                                     @RequestParam(value = "pais", required = false) String nombre_pais,
                                     @RequestParam(value = "codigoPais", required = false) String codigoPais,
                                     @RequestParam(value = "valorPais", required = false) Integer valor_pais,
                                     @RequestParam(value = "valorCiudad", required = false) Integer valor_ciudad,
                                     @RequestParam(value = "año", required = true) Integer año,
                                     @RequestParam(value = "tipoSede", required = true) String tipo


    ) {
        JuegosDTO juegosdto = new JuegosDTO(nombre_pais, nombre_ciudad, codigoPais, valor_ciudad, valor_pais, tipo, año);

        HttpStatus codigo = HttpStatus.OK;
        Juegos j = null;
        try {
            j = juegosService.guardarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;
            LOGGER.info(ex.getMessage());

        }


        return new ResponseEntity<Juegos>(j, codigo);
    }

    @DeleteMapping("/juegos/eliminar")
    ResponseEntity<String> deleteJuegos(


            @RequestParam(value = "año", required = true) Integer año,

            @RequestParam(value = "tipoSede", required = true) String tipo


    ) {
        JuegosDTO juegosdto = new JuegosDTO(año, tipo);
        HttpStatus codigo = HttpStatus.OK;
        boolean borrar = false;
        try {
            borrar = juegosService.borrarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;
            LOGGER.info(ex.getMessage());
            return new ResponseEntity<String>("Error ", codigo);

        }
        if (borrar)

            return new ResponseEntity<String>("Eliminado correctamente ", codigo);
        else {
            return new ResponseEntity<String>("No existe ", codigo);

        }


    }

    @PutMapping("/juegos/modificar")
    ResponseEntity<Juegos> editJuegos(@RequestParam(value = "ciudad", required = false) String nombre_ciudad,
                                      @RequestParam(value = "pais", required = false) String nombre_pais,
                                      @RequestParam(value = "codigoPais", required = false) String codigoPais,
                                      @RequestParam(value = "valorPais", required = false) Integer valorPais,


                                      @RequestParam(value = "año", required = true) Integer año,
                                      @RequestParam(value = "nuevoAño", required = false) Integer nuevoAño,
                                      @RequestParam(value = "tipoSede", required = true) String tipo,
                                      @RequestParam(value = "idCiudad", required = false) Integer id_ciudad,

                                      @RequestParam(value = "nuevoTipoSede", required = false) String nuevoTipoSede


    ) {
        JuegosDTO juegosdto = new JuegosDTO(nombre_pais, nombre_ciudad, id_ciudad, codigoPais, tipo, año, nuevoAño, nuevoTipoSede,valorPais);
        HttpStatus codigo = HttpStatus.OK;
        Juegos j = null;
        try {
            j = juegosService.editarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;
            LOGGER.info(ex.getMessage());

        }
        if (j == null) {
            codigo = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<Juegos>(j, codigo);
    }


}
