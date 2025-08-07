package com.cadastrosimples.CadastroSimples.domain.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastrosimples.CadastroSimples.domain.model.UsuarioModel;
import com.cadastrosimples.CadastroSimples.domain.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @Transactional
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
