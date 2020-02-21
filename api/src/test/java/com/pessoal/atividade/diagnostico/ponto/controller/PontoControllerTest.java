package com.pessoal.atividade.diagnostico.ponto.controller;

import com.pessoal.atividade.diagnostico.ponto.service.RegistroPontoService;
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
public class PontoControllerTest {
    @LocalServerPort
    private Long port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private RegistroPontoService pontoService;

    @Test
    public void testBaterPonto() {

    }

    @Test
    public void relatorioPonto() {

    }
}