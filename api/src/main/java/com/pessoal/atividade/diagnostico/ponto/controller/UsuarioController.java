package com.pessoal.atividade.diagnostico.ponto.controller;

import com.pessoal.atividade.diagnostico.ponto.exception.UsuarioNotFoundException;
import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import com.pessoal.atividade.diagnostico.ponto.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;

// tag::hateoas-imports[]
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
// end::hateoas-imports[]

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }

    @GetMapping("/usuarios")
    public CollectionModel<EntityModel<Usuario>> all() {

        List<EntityModel<Usuario>> usuarios = usuarioRepository.findAll().stream()
                .map(usuario -> new EntityModel<>(usuario,
                        linkTo(methodOn(UsuarioController.class).one(usuario.getId())).withSelfRel(),
                        linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios")))
                .collect(Collectors.toList());

        return new CollectionModel<>(usuarios,
                linkTo(methodOn(UsuarioController.class).all()).withSelfRel());
    }

    @PostMapping("/usuario")
    public Usuario novoUsuario(@RequestBody Usuario novoUsuario) {
        return usuarioRepository.save(novoUsuario);
    }

    @GetMapping("/usuario/{id}")
    public EntityModel<Usuario> one(@PathVariable Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        return new EntityModel<>(usuario,
                linkTo(methodOn(UsuarioController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios"));
    }

    @PutMapping("/usuario/{id}")
    public Usuario atualizaUsuario(@RequestBody Usuario novoUsuario, @PathVariable Long id) {

        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(novoUsuario.getNome());
                    usuario.setEmail(novoUsuario.getEmail());
                    usuario.setCpf(novoUsuario.getCpf());
                    return usuarioRepository.save(usuario);
                })
                .orElseGet(() -> {
                    novoUsuario.setId(id);
                    return usuarioRepository.save(novoUsuario);
                });
    }
}
