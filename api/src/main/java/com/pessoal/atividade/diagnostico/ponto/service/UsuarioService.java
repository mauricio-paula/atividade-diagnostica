package com.pessoal.atividade.diagnostico.ponto.service;

import com.pessoal.atividade.diagnostico.ponto.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario criar(Usuario usuario);

    public List<Usuario> listar();

    public Usuario atualizar(Usuario usuario, Long id);

    public Usuario getBy(Long id);

}
