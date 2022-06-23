package com.example.demorest.api;

import com.example.demorest.anotaciones.Validador;
import com.example.demorest.api.model.*;
import com.example.demorest.dtos.CiudadSede;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.dtos.Sede;
import com.example.demorest.entities.Juegos;
import com.example.demorest.services.JuegosService;
import com.example.demorest.services.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.ValidationException;
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
    @Autowired
    LogInService logInService;

    public JuegosApiDelegate() {
    }

    Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /juegos/anadir : Anadir sedes
     *
     * @param inlineObject (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#anadirSedes
     */
    ResponseEntity<List<CiudadSede>> anadirSedes(ModeloAPIAnadir inlineObject) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        JuegosDTO juegosdto = new JuegosDTO(inlineObject.getPais(), inlineObject.getCiudad(), inlineObject.getCodigoPais(), inlineObject.getValorCiudad(), inlineObject.getValorPais(), inlineObject.getTipo(), inlineObject.getAno());
        try {
            Validador.procesarFields(juegosdto);
        } catch (ValidationException exception) {
            return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), HttpStatus.BAD_REQUEST);
        }
        HttpStatus codigo = HttpStatus.OK;
        Juegos j = null;
        try {
            j = juegosService.guardarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), codigo);
    }

    /**
     * POST /juegos/eliminar : Eliminar sedes
     *
     * @param inlineObject2 (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#eliminarSedes
     */
    ResponseEntity<List<CiudadSede>> eliminarSedes(ModeloAPIEliminar inlineObject2) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        JuegosDTO juegosdto = new JuegosDTO(inlineObject2.getAno(), inlineObject2.getTipo());
        try {
            Validador.procesarFields(juegosdto);
        } catch (ValidationException exception) {
            return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), HttpStatus.BAD_REQUEST);
        }
        HttpStatus codigo = HttpStatus.OK;
        boolean borrar = false;
        try {
            borrar = juegosService.borrarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), codigo);
    }

    /**
     * POST /juegos/filtrar : Filtrar sedes
     *
     * @param inlineObject1 (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#filtrarSedes
     */
    ResponseEntity<List<CiudadSede>> filtrarSedes(ModeloAPIFiltrar inlineObject3) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        HttpStatus codigo = HttpStatus.OK;
        List<CiudadSede> juegos;
        try {
            juegos = juegosService.filtrarJuegos(inlineObject3.getFiltro());
        } catch (Exception ex) {
            codigo = HttpStatus.BAD_REQUEST;
            System.out.println(ex.getMessage());
            return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), codigo);
        }
        return new ResponseEntity<List<CiudadSede>>(juegos, codigo);
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
    ResponseEntity<List<Sede>> buscarSedes(Integer ciudad, String tipo) {
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
        List<Sede> j = juegosService.findJuegosCiudad(ciudad, tipo);
        return new ResponseEntity<List<Sede>>(j, codigo);
    }

    /**
     * POST /juegos/modificar : Modificar sedes
     *
     * @param inlineObject1 (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     * @see JuegosApi#modificarSedes
     */
    ResponseEntity<List<CiudadSede>> modificarSedes(ModeloAPIEditar inlineObject1) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        JuegosDTO juegosdto = new JuegosDTO(inlineObject1.getPais(), inlineObject1.getCiudad(), inlineObject1.getIdCiudad(), inlineObject1.getCodigoPais(), inlineObject1.getTipo(), inlineObject1.getAno(), inlineObject1.getNuevoAno(), inlineObject1.getNuevoTipo(), inlineObject1.getValorPais());
        try {
            Validador.procesarFields(juegosdto);
        } catch (ValidationException exception) {
            return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), HttpStatus.BAD_REQUEST);
        }
        HttpStatus codigo = HttpStatus.OK;
        Juegos j = null;
        try {
            j = juegosService.editarJuegos(juegosdto);
        } catch (DataIntegrityViolationException ex) {
            codigo = HttpStatus.BAD_REQUEST;
            System.out.println(ex.getMessage());
        }
        if (j == null) {
            codigo = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), codigo);
    }

    /**
     * GET /juegos : Lista de sedes
     * Listar las ciudades que fueron  sede
     *
     * @return successful operation (status code 200)
     * or bad request (status code 404)
     * @see JuegosApi#obtenerSedes
     */
    ResponseEntity<List<CiudadSede>> obtenerSedes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nombre_ciudad\" : \"nombre_ciudad\", \"nombre_pais\" : \"nombre_pais\", \"numero_veces_sede\" : 5, \"valor\" : 1, \"id_ciudad\" : 6, \"descripcion_tipo_jjoo\" : \"descripcion_tipo_jjoo\", \"id_pais\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<List<CiudadSede>>(juegosService.findAll(), HttpStatus.OK);
    }

    /**
     * POST /juegos/login : LogIn
     *
     * @param modeloLogin (required)
     * @return successful operation (status code 200)
     * or Log in incorrecto (status code 400)
     * or Not found (status code 404)
     * @see JuegosApi#login
     */
    ResponseEntity<Void> login(ModeloLogin modeloLogin) {
        boolean resp = logInService.checkLogin(modeloLogin.getUser(), modeloLogin.getPassword());
        if (resp) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
