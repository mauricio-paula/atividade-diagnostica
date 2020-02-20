package com.pessoal.atividade.diagnostico.ponto.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String dataCadastro;

    public Usuario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataCadastro = "";
    }
}