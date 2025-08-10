package com.cadastrosimples.CadastroSimples.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastrosimples.CadastroSimples.domain.model.ContatoModel;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long>{

}
