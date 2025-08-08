package com.cadastrosimples.CadastroSimples.api.controller;

import java.util.List;

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

import com.cadastrosimples.CadastroSimples.domain.model.UsuarioModel;
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

    @GetMapping
    public List<UsuarioModel> List() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/GetByNome")
    public List<UsuarioModel> ListByNome(@RequestParam String nome) {
        return usuarioRepository.findByNomeContaining(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> ListByNome(@PathVariable long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel cadastrar(@Valid @RequestBody UsuarioModel usuarioModel) {
        return usuarioService.salvar(usuarioModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizar(@Valid @PathVariable long id, @RequestBody UsuarioModel usuarioModel) {
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
