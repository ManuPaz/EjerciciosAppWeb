package peticionesRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelOption;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.ZonedDateTime;

import java.util.Base64;
import java.util.Collections;

public class VerJuegos {
    private String restService;
    private String user;
    private String password;


    public VerJuegos(String restService,String user,String password) {
        this.restService = restService;
        this.user=user;
        this.password=password;

    }
    private  HttpHeaders createHeaders(){
        String autho = this.user+ ":" + this.password;
        return new HttpHeaders() {{
            //String auth = username + ":" + password;
            String auth = autho;
            //byte[] encodedAuth = Base64.encodeBase64(
              //      auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + auth;
            set( "Authorization", authHeader );
        }};
    }
    public JsonNode pedirJuegos() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String plainCreds = "admin:manuel";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        //ResponseEntity<String> response
          //      = restTemplate.getForEntity(restService + "/juegos", String.class);
        ResponseEntity<String> response = restTemplate.exchange(restService, HttpMethod.GET, request, String.class);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response.getStatusCode());
        JsonNode root = mapper.readTree(response.getBody());
        return root;






    }
}
