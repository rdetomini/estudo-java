package com.cadastrosimples.CadastroSimples.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastrosimples.CadastroSimples.domain.model.ContatoModel;
import com.cadastrosimples.CadastroSimples.domain.repository.ContatoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Transactional
    public ContatoModel create(ContatoModel contatoModel) {
        return contatoRepository.save(contatoModel);
    }

    public List<ContatoModel> listAll() {
        return contatoRepository.findAll();
    }

    public Optional<ContatoModel> getById(long id) {
        return contatoRepository.findById(id);
    }
}
