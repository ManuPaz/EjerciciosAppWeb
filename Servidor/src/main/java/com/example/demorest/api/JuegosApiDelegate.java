package com.example.demorest.api;

import com.example.demorest.dtos.JuegosCiudades;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Juegos;
import com.example.demorest.model.Sede;
import com.example.demorest.services.JuegosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;


/**
 * A delegate to be called by the {@link JuegosApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-14T09:36:03.661556900+01:00[Europe/Madrid]")
@Component("beanName2")
public class JuegosApiDelegate {

    @Autowired
    JuegosService juegosService;

    public JuegosApiDelegate() {

    }

    Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /juegos/{ano}/{tipo} : Anadir sedes
     *
     * @param ano         Ano de la edicion  (required)
     * @param tipo        Tipo de edicion: invierno y verano  (required)
     * @param ciudad      Nombre de  la ciudad  (required)
     * @param pais        Nombre del pais  (optional)
     * @param codigoPais  Codigo del pais  (optional)
     * @param valorPais   Valor del pais  (optional)
     * @param valorCiudad Valor de la ciudad  (optional)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#anadirSedes
     */
    ResponseEntity<List<JuegosCiudades>> anadirSedes(Integer ano,
                                                     String tipo,
                                                     String ciudad,
                                                     String pais,
                                                     String codigoPais,
                                                     Integer valorPais,
                                                     Integer valorCiudad) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        JuegosDTO juegosdto = new JuegosDTO(pais, ciudad, codigoPais, valorPais, valorPais, tipo, ano);

        HttpStatus codigo = HttpStatus.OK;
        Juegos j = null;
        try {
            j = juegosService.guardarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;


        }


        return new ResponseEntity<List<JuegosCiudades>>(juegosService.findJuegosCiudades(), codigo);

    }

    /**
     * DELETE /juegos/{ano}/{tipo} : Borrar sede
     * Borra la sede.
     *
     * @param ano  Ano de la edicion  (required)
     * @param tipo Tipo de edicion: invierno y verano  (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#borrarSede
     */
    ResponseEntity<List<JuegosCiudades>> borrarSede(Integer ano,
                                                    String tipo) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        JuegosDTO juegosdto = new JuegosDTO(ano, tipo);
        HttpStatus codigo = HttpStatus.OK;
        boolean borrar = false;
        try {
            borrar = juegosService.borrarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;


        }
        return new ResponseEntity<List<JuegosCiudades>>(juegosService.findJuegosCiudades(), codigo);

    }

    /**
     * GET /juegos/buscar : Buscar los anos que una ciudad fue sede
     * Anos en que una ciudad fue sede y el tipo de sede que fue
     *
     * @param ciudad Id de la ciudad.  (required)
     * @param tipo   Tipo de sede: invierno o verano. (required)
     * @return successful operation (status code 200)
     * or bad request (status code 404)
     * @see JuegosApi#buscarSedes
     */
    ResponseEntity<List<Sede>> buscarSedes(Integer ciudad,
                                           String tipo) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ano\" : 0, \"descripcion_tipo\" : \"descripcion_tipo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        HttpStatus codigo = HttpStatus.OK;
        List<com.example.demorest.model.Sede> j = juegosService.findJuegosCiudad(ciudad, tipo);
        return new ResponseEntity<List<Sede>>(j, codigo);

    }

    /**
     * PUT /juegos/{ano}/{tipo} : Modificar sedes
     *
     * @param ano        Ano de la edicion  (required)
     * @param tipo       Tipo de edicion: invierno y verano  (required)
     * @param nuevoAno   Nuevo ano de la edicion  (optional)
     * @param nuevoTipo  Nuevo tipo de edicion: invierno y verano  (optional)
     * @param pais       Nombre del pais  (optional)
     * @param codigoPais Codigo del pais  (optional)
     * @param ciudad     Nombre de  la nueva  ciudad  (optional)
     * @param valorPais  Valor del pais  (optional)
     * @param idCiudad   Id de la nueva ciudad  (optional)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#editarJuegos
     */
    ResponseEntity<List<JuegosCiudades>> editarJuegos(Integer ano,
                                                      String tipo,
                                                      Integer nuevoAno,
                                                      String nuevoTipo,
                                                      String pais,
                                                      String codigoPais,
                                                      String ciudad,
                                                      Integer valorPais,
                                                      Integer idCiudad) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        JuegosDTO juegosdto = new JuegosDTO(pais, ciudad, idCiudad, codigoPais, tipo, ano, nuevoAno, nuevoTipo, valorPais);
        HttpStatus codigo = HttpStatus.OK;
        Juegos j = null;
        try {
            j = juegosService.editarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;


        }
        if (j == null) {
            codigo = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<List<JuegosCiudades>>(juegosService.findJuegosCiudades(), codigo);


    }

    /**
     * GET /juegos : Lista de sedes
     * Listar las ciudades que fueron  sede
     *
     * @return successful operation (status code 200)
     * or bad request (status code 404)
     * @see JuegosApi#obtenerSedes
     */
    ResponseEntity<List<JuegosCiudades>> obtenerSedes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<List<JuegosCiudades>>(juegosService.findJuegosCiudades(), HttpStatus.OK);

    }

}
