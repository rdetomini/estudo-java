package com.cadastrosimples.CadastroSimples.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cadastrosimples.CadastroSimples.api.model.UsuarioModel;
import com.cadastrosimples.CadastroSimples.domain.model.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UsuarioAssembler {

    private final ModelMapper modelMapper;

    public UsuarioModel toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios) {
        return usuarios.stream().map(this::toModel).toList();
    }
}
