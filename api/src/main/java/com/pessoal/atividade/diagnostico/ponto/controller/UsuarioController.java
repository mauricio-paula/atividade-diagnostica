package com.pessoal.atividade.diagnostico.ponto.controller;

import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import com.pessoal.atividade.diagnostico.ponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    //Criacao
    @PostMapping("/usuarios")
    public Usuario criarUsuario(@Valid @RequestBody Usuario novoUsuario)
    {
        return _usuarioRepository.save(novoUsuario);
    }

    //Edicao
    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable(value = "id") Long id, @Valid @RequestBody Usuario novoUsuario)
    {
        Optional<Usuario> usuarioAntigo = _usuarioRepository.findById(id);
        if(usuarioAntigo.isPresent()) {
            Usuario usuario = usuarioAntigo.get();
            usuario.setNome(novoUsuario.getNome());
            usuario.setCpf(novoUsuario.getCpf());
            usuario.setEmail(novoUsuario.getEmail());
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Consulta
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> consultarUsuario(@PathVariable(value = "id") Long id)
    {
        Optional<Usuario> usuario = _usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Listagem
    @GetMapping("/usuarios/")
    List<Usuario> listarUsuarios()
    {
        return _usuarioRepository.findAll();
    }
}
