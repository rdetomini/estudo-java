package com.cadastrosimples.CadastroSimples.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastrosimples.CadastroSimples.domain.model.ContatoModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {

    @Transactional
    public ContatoModel create(ContatoModel contatoModel) {
        return contatoModel;
    }

    public List<ContatoModel> listAll() {
        return new ArrayList<>();
    }

    public Optional<ContatoModel> getById(long id) {
        return Optional.empty();
    }
}
