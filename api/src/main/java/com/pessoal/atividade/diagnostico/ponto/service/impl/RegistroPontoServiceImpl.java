package com.pessoal.atividade.diagnostico.ponto.service.impl;

import com.pessoal.atividade.diagnostico.ponto.model.PontosUsuario;
import com.pessoal.atividade.diagnostico.ponto.model.RegistroPonto;
import com.pessoal.atividade.diagnostico.ponto.repository.PontoRepository;
import com.pessoal.atividade.diagnostico.ponto.service.RegistroPontoService;
import com.pessoal.atividade.diagnostico.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroPontoServiceImpl implements RegistroPontoService {

    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public RegistroPonto registrarPonto(RegistroPonto ponto) {
        return null;
    }

    @Override
    public PontosUsuario consultar(Long idUsuario) {
        return null;
    }
}
