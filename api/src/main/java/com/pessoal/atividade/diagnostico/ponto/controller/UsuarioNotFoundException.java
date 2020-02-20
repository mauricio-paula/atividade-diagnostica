package com.pessoal.atividade.diagnostico.ponto.controller;

public class UsuarioNotFoundException extends RuntimeException {
    UsuarioNotFoundException(Long id) {
        super("Nao foi possivel localizar o usuario " + id);
    }
}
