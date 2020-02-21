package com.pessoal.atividade.diagnostico.ponto.model;

import lombok.Data;
import org.joda.time.LocalDate;

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
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataCadastro;

    public Usuario() {}

    public Usuario(Long id, String nome, String cpf, String email, LocalDate dataCadastro) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setDataCadastro(LocalDate.now());
    }

    private void updateNome(String nome) {
        this.nome = nome;
    }

    private void updateCpf(String cpf) {
        this.cpf = cpf;
    }

    private void updateEmail(String email) {
        this.email = email;
    }

    public void updateDados(Usuario usuario) {
        updateNome(usuario.getNome());
        updateCpf(usuario.getCpf());
        updateEmail(usuario.getEmail());
    }

    public static class Builder {

        private Long id;

        private String nome;

        private String cpf;

        private String email;

        private LocalDate dataCadastro;

        public Builder(Long id){
            this.id = id;
        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder comEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder comDataCadastro(LocalDate dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }

        public Usuario build() {
            return new Usuario(this.id, this.nome, this.cpf, this.email, this.dataCadastro);
        }
    }
}