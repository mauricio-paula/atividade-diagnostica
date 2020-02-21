package com.pessoal.atividade.diagnostico.ponto.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super("Nao foi possivel localizar o usuario " + id);
    }
}
