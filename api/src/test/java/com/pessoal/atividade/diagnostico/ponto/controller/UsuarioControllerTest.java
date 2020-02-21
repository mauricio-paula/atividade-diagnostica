package com.pessoal.atividade.diagnostico.ponto.controller;

import com.pessoal.atividade.diagnostico.ponto.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UsuarioControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    public void deveRetornarListagemUsuarios() {
    }

    @Test
    public void deveRetornarUsuario() {
    }

    @Test
    public void deveIncluirUsuario() {
    }

    private String host() {
        return "http://localhost:" + port + "/v1/";
    }

    private String usuariosEndpoint() {
        return host() + "usuarios";
    }
}