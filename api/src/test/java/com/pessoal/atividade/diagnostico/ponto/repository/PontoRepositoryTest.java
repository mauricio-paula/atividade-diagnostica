package com.pessoal.atividade.diagnostico.ponto.repository;

import com.pessoal.atividade.diagnostico.ponto.model.RegistroPonto;
import com.pessoal.atividade.diagnostico.ponto.model.TipoRegistro;
import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PontoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    public void registrarPontoTest() {

        Usuario usuario = criarUsuario();

        RegistroPonto entrada = new RegistroPonto
                .Builder(null)
                .comUsuario(usuario)
                .comHora(LocalDateTime.now().minusHours(1))
                .comTipoRegistro(TipoRegistro.ENTRADA)
                .build();

        RegistroPonto saida = new RegistroPonto
                .Builder(null)
                .comUsuario(usuario)
                .comHora(LocalDateTime.now().plusHours(2))
                .comTipoRegistro(TipoRegistro.SAIDA)
                .build();

        RegistroPonto entrada2 = new RegistroPonto
                .Builder(null)
                .comUsuario(usuario)
                .comHora(LocalDateTime.now().plusHours(4))
                .comTipoRegistro(TipoRegistro.ENTRADA)
                .build();

        RegistroPonto saida2 = new RegistroPonto
                .Builder(null)
                .comUsuario(usuario)
                .comHora(LocalDateTime.now().plusHours(8))
                .comTipoRegistro(TipoRegistro.SAIDA)
                .build();

        pontoRepository.save(entrada);
        pontoRepository.save(saida);
        pontoRepository.save(entrada2);
        pontoRepository.save(saida2);

        List<RegistroPonto> pontos = pontoRepository.findByUsuario(usuario);
        Assertions.assertThat(pontos.size()).isEqualTo(4);


    }

    private Usuario criarUsuario() {
        Usuario usuario = new Usuario
                .Builder(null)
                .comNome("Novo User")
                .comCpf("12345678910")
                .comEmail("user@test.com")
                .comDataCadastro(LocalDate.now())
                .build();
        return entityManager.persistAndFlush(usuario);
    }
}
