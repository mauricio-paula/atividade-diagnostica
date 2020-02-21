package com.pessoal.atividade.diagnostico.ponto.model;

public enum TipoRegistro {

    ENTRADA ("E"), SAIDA("S");

    private final String tipo;
    TipoRegistro(String _tipo) {
        tipo = _tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
