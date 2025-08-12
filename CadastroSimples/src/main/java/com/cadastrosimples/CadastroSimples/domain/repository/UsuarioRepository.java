package com.cadastrosimples.CadastroSimples.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastrosimples.CadastroSimples.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     List<Usuario> findByNomeContaining(String nome);
}
