package com.cadastrosimples.CadastroSimples.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastrosimples.CadastroSimples.domain.model.Contato;
import com.cadastrosimples.CadastroSimples.domain.repository.ContatoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Transactional
    public Contato create(Contato contato) {
        return contatoRepository.save(contato);
    }

    public List<Contato> listAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> getById(long id) {
        return contatoRepository.findById(id);
    }
}
