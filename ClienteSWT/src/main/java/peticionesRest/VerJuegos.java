package peticionesRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import avisos.MensajesError;

public class VerJuegos {
    private String restService;
    private String user;
    private String password;
    private MensajesError mensajesError;


    public VerJuegos(String restService,String user,String password,MensajesError mensajesError) {
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

        JsonNode root = mapper.readTree(response.getBody());
        return root;


    }
    public JsonNode pedirJuegos() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request=this.createHeaders();
        ResponseEntity<String> response = restTemplate.exchange(restService+"/juegos", HttpMethod.GET, request, String.class);
        return this.devolverRespuesta(response);







    }
    public JsonNode buscarPorCiudad(Integer idCiudad) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request=this.createHeaders();

        ResponseEntity<String> response = restTemplate.exchange(restService+"/juegos/ciudad?ciudad={idciudad}", HttpMethod.GET, request, String.class,(idCiudad));

        return this.devolverRespuesta(response);







    }
}
