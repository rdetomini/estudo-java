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

import com.cadastrosimples.CadastroSimples.domain.model.Contato;
import com.cadastrosimples.CadastroSimples.domain.service.ContatoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contato")
@AllArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @GetMapping
    public List<Contato> listAll() {
        return contatoService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable long id) {
        return contatoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Contato create(@Valid @RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable long id, @RequestBody Contato contato) {
        contato.setId(id);
        var contatoUpdated = contatoService.create(contato);

        return ResponseEntity.ok(contatoUpdated);
    }
}
