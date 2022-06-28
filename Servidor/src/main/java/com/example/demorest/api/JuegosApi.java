/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.demorest.api;

import com.example.demorest.api.model.*;
import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.dtos.Sede;
import com.example.demorest.dtos.CiudadSede;
import com.example.demorest.entities.Juegos;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-14T09:36:03.661556900+01:00[Europe/Madrid]")
@Validated
@Api(value = "juegos", description = "the juegos API")
public abstract class JuegosApi {
    public abstract JuegosApiDelegate getDelegate();

    /**
     * POST /juegos/anadir : Anadir sedes
     *
     * @param inlineObject (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     */
    @ApiOperation(value = "Anadir sedes", nickname = "anadirSedes", notes = "", response = CiudadSede.class, responseContainer = "List", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags = {"juegos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CiudadSede.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Atributos de sede no válidos"),
            @ApiResponse(code = 404, message = "Sede no encontrada")})
    @RequestMapping(value = "/juegos/anadir",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<List<CiudadSede>> anadirSedes(@ApiParam(value = "", required = true) @Valid @RequestBody ModeloAPIAnadir inlineObject) {
        return getDelegate().anadirSedes(inlineObject);
    }

    /**
     * POST /juegos/anadir/multiple : Anadir sedes
     *
     * @param nuevoJuego  (required)
     * @return successful operation (status code 200)
     *         or Atributos de sede no válidos (status code 400)
     *         or Sede no encontrada (status code 404)
     */
    @ApiOperation(value = "Anadir sedes", nickname = "anadirMultiplesSedes", notes = "", response = Juegos.class, responseContainer = "List", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags={ "juegos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Atributos de sede no válidos"),
            @ApiResponse(code = 404, message = "Sede no encontrada") })
    @RequestMapping(value = "/juegos/anadir/multiple",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> anadirMultiplesSedes(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<JuegosDTO> nuevoJuego) {
        return getDelegate().anadirMultiplesSedes(nuevoJuego);
    }

    /**
     * POST /juegos/anadir/multiple/checkingIds : Anadir sedes
     *
     * @param nuevoJuego  (required)
     * @return successful operation (status code 200)
     *         or Atributos de sede no válidos (status code 400)
     *         or Sede no encontrada (status code 404)
     */
    @ApiOperation(value = "Anadir multiples sedes sabiendo ids", nickname = "anadirMultiplesSedesPorIDs", notes = "", response = Juegos.class, responseContainer = "List", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags={ "juegos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Atributos de sede no válidos"),
            @ApiResponse(code = 404, message = "Sede no encontrada") })
    @RequestMapping(value = "/juegos/anadir/multiple/checkingIds",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> anadirMultiplesSedesPorIDs(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<JuegosDTO> nuevoJuego) {
        return getDelegate().anadirMultiplesSedesCheckingIds(nuevoJuego);
    }

    /**
     * POST /juegos/eliminar : Eliminar sedes
     *
     * @param inlineObject2 (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     */
    @ApiOperation(value = "Eliminar sedes", nickname = "eliminarSedes", notes = "", response = CiudadSede.class, responseContainer = "List", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags = {"juegos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CiudadSede.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Atributos de sede no válidos"),
            @ApiResponse(code = 404, message = "Sede no encontrada")})
    @RequestMapping(value = "/juegos/eliminar",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<List<CiudadSede>> eliminarSedes(@ApiParam(value = "", required = true) @Valid @RequestBody ModeloAPIEliminar inlineObject2) {
        return getDelegate().eliminarSedes(inlineObject2);
    }

    /**
     * GET /juegos/buscar : Buscar los anos que una ciudad fue sede
     * Anos en que una ciudad fue sede y el tipo de sede que fue
     *
     * @param ciudad Id de la ciudad.  (required)
     * @param tipo   Tipo de sede: invierno o verano. (required)
     * @return successful operation (status code 200)
     * or bad request (status code 404)
     */
    @ApiOperation(value = "Buscar los anos que una ciudad fue sede", nickname = "buscarSedes", notes = "Anos en que una ciudad fue sede y el tipo de sede que fue", response = Sede.class, responseContainer = "List", tags = {"juegos",}, authorizations = {
            @Authorization(value = "basicAuth")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Sede.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "bad request")})
    @RequestMapping(value = "/juegos/buscar",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Sede>> buscarSedes(@NotNull @ApiParam(value = "Id de la ciudad. ", required = true) @Valid @RequestParam(value = "ciudad", required = true) Integer ciudad, @NotNull @ApiParam(value = "Tipo de sede: invierno o verano.", required = true) @Valid @RequestParam(value = "tipo", required = true) String tipo) {
        return getDelegate().buscarSedes(ciudad, tipo);
    }

    /**
     * POST /juegos/modificar : Modificar sedes
     *
     * @param inlineObject1 (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     */
    @ApiOperation(value = "Modificar sedes", nickname = "modificarSedes", notes = "", response = CiudadSede.class, responseContainer = "List", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags = {"juegos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CiudadSede.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Atributos de sede no válidos"),
            @ApiResponse(code = 404, message = "Sede no encontrada")})
    @RequestMapping(value = "/juegos/modificar",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<List<CiudadSede>> modificarSedes(@ApiParam(value = "", required = true) @Valid @RequestBody ModeloAPIEditar inlineObject1) {
        return getDelegate().modificarSedes(inlineObject1);
    }

    /**
     * POST /juegos/filtrar : Filtrar sedes
     *
     * @param inlineObject1 (required)
     * @return successful operation (status code 200)
     * or Atributos de sede no válidos (status code 400)
     * or Sede no encontrada (status code 404)
     */
    @ApiOperation(value = "Filtrar sedes", nickname = "filtrarSedes", notes = "", response = CiudadSede.class, responseContainer = "List", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags = {"juegos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CiudadSede.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Atributos de sede no válidos"),
            @ApiResponse(code = 404, message = "Sede no encontrada")})
    @RequestMapping(value = "/juegos/filtrar",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<List<CiudadSede>> filtrarSedes(@ApiParam(value = "", required = true) @Valid @RequestBody ModeloAPIFiltrar inlineObject3) {
        return getDelegate().filtrarSedes(inlineObject3);
    }

    /**
     * GET /juegos : Lista de sedes
     * Listar las ciudades que fueron  sede
     *
     * @return successful operation (status code 200)
     * or bad request (status code 404)
     */
    @ApiOperation(value = "Lista de sedes", nickname = "obtenerSedes", notes = "Listar las ciudades que fueron  sede", response = CiudadSede.class, tags = {"juegos",}, authorizations = {
            @Authorization(value = "basicAuth")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CiudadSede.class),
            @ApiResponse(code = 404, message = "bad request")})
    @RequestMapping(value = "/juegos",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<CiudadSede>> obtenerSedes() {
        return getDelegate().obtenerSedes();
    }

    /**
     * POST /juegos/login : LogIn
     *
     * @param modeloLogin (required)
     * @return successful operation (status code 200)
     * or Log in incorrecto (status code 400)
     * or Not found (status code 404)
     */
    @ApiOperation(value = "LogIn", nickname = "login", notes = "", authorizations = {
            @Authorization(value = "basicAuth")
    }, tags = {"juegos,login",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Log in incorrecto"),
            @ApiResponse(code = 404, message = "Not found")})
    @RequestMapping(value = "/juegos/login",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> login(@ApiParam(value = "", required = true) @Valid @RequestBody ModeloLogin modeloLogin) {
        return getDelegate().login(modeloLogin);
    }
}
