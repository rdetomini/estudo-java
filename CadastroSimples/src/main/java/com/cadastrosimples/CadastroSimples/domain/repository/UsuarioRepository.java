package com.cadastrosimples.CadastroSimples.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastrosimples.CadastroSimples.domain.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
     List<UsuarioModel> findByNomeContaining(String nome);
}
