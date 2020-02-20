package com.pessoal.atividade.diagnostico.ponto.repository;

import com.pessoal.atividade.diagnostico.ponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
