package peticionesRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import interfaz.Constante;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import avisos.MensajesError;
import org.springframework.web.util.UriComponentsBuilder;

public class RestJuegos {
    private String restService;
    private String user;
    private String password;
    private MensajesError mensajesError;


    public RestJuegos(String restService, String user, String password, MensajesError mensajesError) {
        this.restService = restService;
        this.user=user;
        this.mensajesError=mensajesError;
        this.password=password;

    }
    private   HttpEntity<String>  createHeaders(){
        String plainCreds =    this.user+":"+this.password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        return request;
    }
    private JsonNode devolverRespuesta(ResponseEntity<String> response ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (response.hasBody()) {
            JsonNode root = mapper.readTree(response.getBody().toString());
            return root;
        }
        else return null;



    }
    private String devolverConfirmacion(ResponseEntity<String> response ) throws JsonProcessingException {



        return (response.getBody().toString());


    }
    public JsonNode pedirJuegos() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request=this.createHeaders();
        ResponseEntity<String> response = restTemplate.exchange(restService+"/juegos", HttpMethod.GET, request, String.class);
        return this.devolverRespuesta(response);







    }
    public void eliminarJuegos(Integer año,String tipoJuegos) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request=this.createHeaders();

        ResponseEntity<String> response = restTemplate.exchange(restService+"/juegos/eliminar?año={año}&tipoSede={tipo}", HttpMethod.POST, request, String.class,(año),tipoJuegos);

       this.mensajesError.confirmar(this.devolverConfirmacion(response));

    }
    public void modificarJuegos(Integer año,String tipoJuegos) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request=this.createHeaders();

        ResponseEntity<String> response = restTemplate.exchange(restService+"/juegos/eliminar?año={año}&tipoSede={tipo}", HttpMethod.POST, request, String.class,(año),tipoJuegos);

        this.mensajesError.confirmar(this.devolverConfirmacion(response));

    }
    public boolean modificarJuegos(String nombreCiudad,Integer año,String tipoJuegos,Integer nuevoAño,String nuevoTipo,Integer nuevoId) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request=this.createHeaders();
        String consulta=restService;

        ArrayList<Object> args=new ArrayList<>();
        consulta+="/juegos/modificar?año={año}&tipoSede={tipoSede}";
        args.add(año);
        args.add(tipoJuegos);
        args.add(nombreCiudad);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("año", año);

        params.put("tipoSede",  tipoJuegos);
        if (nombreCiudad!=null){
            consulta+="&ciudad={ciudad}";
            params.put("ciudad",nombreCiudad);

        }
        if (nuevoTipo!=null){
            consulta+="&nuevoTipoSede={nuevoTipoSede}";
            params.put("nuevoTipoSede",nuevoTipo);


        }
        if (nuevoId!=null){
            consulta+="&idCiudad={idCiudad}";
            params.put("idCiudad",nuevoId);


        }
        if (nuevoAño!=null){
            consulta+="&nuevoAño={nuevoAño}";
            params.put("nuevoAño",nuevoAño);

        }

        try {
            ResponseEntity<String> response = restTemplate.exchange(consulta, HttpMethod.POST, request, String.class, params);

        }catch(Exception ex){

            this.mensajesError.avisar(Constante.MENSAJE_CAMPOS_INVALIDOS);
            return false;
        }
        return true;

    }
    public boolean añadirJuegos(String nombreCiudad,Integer año,String tipoJuegos,String pais,String codigoPais,Integer valorCiudad,Integer valorPais) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request=this.createHeaders();
        String consulta=restService;

        ArrayList<Object> args=new ArrayList<>();
        consulta+="/juegos/anadir?año={año}&tipoSede={tipoSede}&ciudad={ciudad}";
        args.add(año);
        args.add(tipoJuegos);
        args.add(nombreCiudad);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("año", año);
        params.put("ciudad", nombreCiudad);
        params.put("tipoSede",  tipoJuegos);
        if (pais!=null){
            consulta+="&pais={pais}";
            params.put("pais",pais);

        }
        if (codigoPais!=null){
            consulta+="&codigoPais={codigoPais}";
            params.put("codigoPais",codigoPais);


        }
        if (valorCiudad!=null){
            consulta+="&valorCiudad={valorCiudad}";
            params.put("valorCiudad",valorCiudad);


        }
        if (valorPais!=null){
            consulta+="&valorPais={valorPais}";
            params.put("valorPais",valorPais);

        }

        try {
            ResponseEntity<String> response = restTemplate.exchange(consulta, HttpMethod.POST, request, String.class, params);

        }catch(Exception ex){

            this.mensajesError.avisar(Constante.MENSAJE_CAMPOS_INVALIDOS);
            return false;
        }
        return true;

    }
    public JsonNode buscarPorCiudad(Integer idCiudad,String tipo) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request=this.createHeaders();


        ResponseEntity<String> response = restTemplate.exchange(restService+"/juegos/ciudad?ciudad={idciudad}&tipo={tipo}", HttpMethod.GET, request, String.class,(idCiudad),tipo);

        return this.devolverRespuesta(response);







    }
}
