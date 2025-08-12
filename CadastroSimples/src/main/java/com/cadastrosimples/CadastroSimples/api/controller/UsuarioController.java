package com.cadastrosimples.CadastroSimples.api.controller;

import java.util.List;

import com.cadastrosimples.CadastroSimples.api.assembler.UsuarioAssembler;
import com.cadastrosimples.CadastroSimples.api.model.UsuarioModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrosimples.CadastroSimples.domain.repository.UsuarioRepository;
import com.cadastrosimples.CadastroSimples.domain.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioAssembler usuarioAssembler;

    @GetMapping
    public List<UsuarioModel> List() {
       return usuarioAssembler.toCollectionModel(usuarioRepository.findAll());
    }

    @GetMapping("/GetByNome")
    public List<UsuarioModel> ListByNome(@RequestParam String nome) {
       return usuarioAssembler.toCollectionModel(usuarioRepository.findByNomeContaining(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> ListByNome(@PathVariable long id) {
        return usuarioRepository.findById(id)
                .map(usuarioAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel cadastrar(@Valid @RequestBody UsuarioModel usuarioModel) {
       return usuarioService.salvar(usuarioModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizar(@PathVariable long id, @Valid @RequestBody UsuarioModel usuarioModel) {
       if (!usuarioRepository.existsById(id)) {
           return ResponseEntity.notFound().build();
       }

       usuarioModel.setId(id);
       UsuarioModel usuarioAtualizado = usuarioService.salvar(usuarioModel);

       return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
