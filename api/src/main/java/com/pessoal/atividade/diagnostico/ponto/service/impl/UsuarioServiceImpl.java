package com.pessoal.atividade.diagnostico.ponto.service.impl;

import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import com.pessoal.atividade.diagnostico.ponto.repository.UsuarioRepository;
import com.pessoal.atividade.diagnostico.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario criar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public Usuario atualizar(Usuario newUsuario, Long id) {
        return repository.findById(id).map((usuario) -> {
            usuario.updateDados(newUsuario);
            return repository.save(usuario);
        }).orElseGet(() -> {
            newUsuario.setId(id);
            return repository.save(newUsuario);
        });
    }

    @Override
    public Usuario getBy(Long id) {
        return null;
    }
}
