package com.pessoal.atividade.diagnostico.ponto.repository;

import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repository) {
        return args -> {
            log.info("Carregando repositorio" + repository.save( new Usuario("Nome Completo", "CPF", "email")));
        };
    }
}
