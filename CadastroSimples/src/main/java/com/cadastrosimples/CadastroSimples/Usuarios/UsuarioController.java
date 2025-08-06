package com.cadastrosimples.CadastroSimples.Usuarios;

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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioRepository usuarioRepository;

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
    public UsuarioModel Cadastrar(@Valid @RequestBody UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> Atualizar(@Valid @PathVariable long id, @RequestBody UsuarioModel usuarioModel) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioModel.setId(id);
        UsuarioModel usuarioAtualizado = usuarioRepository.save(usuarioModel);

        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Excluir(@PathVariable long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
