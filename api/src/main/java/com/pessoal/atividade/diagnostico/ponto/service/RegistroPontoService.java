package com.pessoal.atividade.diagnostico.ponto.service;

import com.pessoal.atividade.diagnostico.ponto.model.PontosUsuario;
import com.pessoal.atividade.diagnostico.ponto.model.RegistroPonto;

public interface RegistroPontoService {
    public RegistroPonto registrarPonto(RegistroPonto ponto);

    public PontosUsuario consultar(Long idUsuario);
}
