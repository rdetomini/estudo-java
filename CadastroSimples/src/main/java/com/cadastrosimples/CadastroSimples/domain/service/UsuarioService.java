package com.cadastrosimples.CadastroSimples.domain.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastrosimples.CadastroSimples.api.model.UsuarioModel;
import com.cadastrosimples.CadastroSimples.domain.model.Usuario;
import com.cadastrosimples.CadastroSimples.domain.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        Usuario usuario = modelMapper.map(usuarioModel, Usuario.class);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSalvo, UsuarioModel.class);
    }

    @Transactional
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
