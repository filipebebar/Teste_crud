package br.com.crudteste.springcrudteste.controller;

import br.com.crudteste.springcrudteste.entity.Desenvolvedor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
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
