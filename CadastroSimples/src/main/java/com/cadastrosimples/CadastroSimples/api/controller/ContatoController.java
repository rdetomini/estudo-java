package com.cadastrosimples.CadastroSimples.api.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrosimples.CadastroSimples.domain.model.ContatoModel;
import com.cadastrosimples.CadastroSimples.domain.service.ContatoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @GetMapping
    public List<ContatoModel> listAll() {
        return contatoService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoModel> getById(@PathVariable long id) {
        return contatoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContatoModel create(@Valid @RequestBody ContatoModel contatoModel) {
        return contatoService.create(contatoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoModel> update(@PathVariable long id, @RequestBody ContatoModel contatoModel) {
        contatoModel.setId(id);
        var contatoUpdated = contatoService.create(contatoModel);

        return ResponseEntity.ok(contatoUpdated);
    }
}
