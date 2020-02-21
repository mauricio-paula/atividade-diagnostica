package com.pessoal.atividade.diagnostico.ponto.repository;

import com.pessoal.atividade.diagnostico.ponto.model.RegistroPonto;
import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoRepository extends JpaRepository<RegistroPonto, Long> {
    public List<RegistroPonto> findByUsuario(Usuario usuario);

    @Query("select p from RegistroPonto p where p.usuario.id = ?1")
    public List<RegistroPonto> findByIdUsuario(Long idUsuario);
}
