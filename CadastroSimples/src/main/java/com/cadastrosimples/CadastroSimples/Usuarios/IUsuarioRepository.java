package com.cadastrosimples.CadastroSimples.Usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
     List<UsuarioModel> findByNomeContaining(String nome);
}
