package com.pessoal.atividade.diagnostico.ponto.controller;

import com.pessoal.atividade.diagnostico.ponto.model.RegistroPonto;
import com.pessoal.atividade.diagnostico.ponto.repository.PontoRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1")
public class PontoController {

    private final PontoRepository pontoRepository;

    public PontoController(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    @PostMapping("/ponto")
    public RegistroPonto registrarPonto(@RequestBody RegistroPonto novoRegistro) {
        return pontoRepository.save(novoRegistro);
    }

    @GetMapping("/ponto/{idUsuario}")
    public CollectionModel<EntityModel<RegistroPonto>> registros(@PathVariable Long idUsuario){

        List<EntityModel<RegistroPonto>> registros = pontoRepository.findByIdUsuario(idUsuario).stream()
                .map(registro -> new EntityModel<>(registro))
                .collect(Collectors.toList());;

        return new CollectionModel<>(registros,
                linkTo(methodOn(PontoController.class).registros(idUsuario)).withSelfRel());
    }
}
