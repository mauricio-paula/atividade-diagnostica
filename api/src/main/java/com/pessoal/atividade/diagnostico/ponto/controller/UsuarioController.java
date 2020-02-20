package com.pessoal.atividade.diagnostico.ponto.controller;

import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import com.pessoal.atividade.diagnostico.ponto.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;

// tag::hateoas-imports[]
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
// end::hateoas-imports[]

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioRepository _usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) { this._usuarioRepository = usuarioRepository; }

    @GetMapping("/usuarios")
    public CollectionModel<EntityModel<Usuario>> all() {

        List<EntityModel<Usuario>> usuarios = _usuarioRepository.findAll().stream()
                .map(usuario -> new EntityModel<>(usuario,
                        linkTo(methodOn(UsuarioController.class).one(usuario.getId())).withSelfRel(),
                        linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios")))
                .collect(Collectors.toList());

        return new CollectionModel<>(usuarios,
                linkTo(methodOn(UsuarioController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/usuario")
    public Usuario novoUsuario(@RequestBody Usuario novoUsuario) {
        return _usuarioRepository.save(novoUsuario);
    }

    // Single item

    // tag::get-single-item[]
    @GetMapping("/usuario/{id}")
    public EntityModel<Usuario> one(@PathVariable Long id) {

        Usuario usuario = _usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        return new EntityModel<>(usuario,
                linkTo(methodOn(UsuarioController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios"));
    }
    // end::get-single-item[]

    @PutMapping("/usuario/{id}")
    public Usuario atualizaUsuario(@RequestBody Usuario novoUsuario, @PathVariable Long id) {

        return _usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(novoUsuario.getNome());
                    usuario.setEmail(novoUsuario.getEmail());
                    usuario.setCpf(novoUsuario.getCpf());
                    return _usuarioRepository.save(usuario);
                })
                .orElseGet(() -> {
                    novoUsuario.setId(id);
                    return _usuarioRepository.save(novoUsuario);
                });
    }
}
