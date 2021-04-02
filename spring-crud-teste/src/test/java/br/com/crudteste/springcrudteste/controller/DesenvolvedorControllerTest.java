package br.com.crudteste.springcrudteste.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesenvolvedorControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    void listarTodos()  throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/developers";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(true, Objects.requireNonNull(result.getBody()).contains("devsList"));
    }

    @Test
    void findDesenvolvedorById() {
    }

    @Test
    void salvarDesenvolvedor() {
    }

    @Test
    void atualizarDesenvolvedor() {
    }

    @Test
    void removerDesenvolvedor() {
    }
}
