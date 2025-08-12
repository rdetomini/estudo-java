package com.cadastrosimples.CadastroSimples.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cadastrosimples.CadastroSimples.api.model.UsuarioModel;
import com.cadastrosimples.CadastroSimples.domain.model.Usuario;

@Configuration
public class ModelMapperConfig  {
    @Bean
    public ModelMapper modelMapper() {
        var modelMaper = new ModelMapper();
        modelMaper.createTypeMap(Usuario.class, UsuarioModel.class)
        .addMappings(mapper -> mapper.map(Usuario::getNome, UsuarioModel::setNome));

        return modelMaper;
    }
}
