package com.cadastrosimples.CadastroSimples.Contatos;

import com.cadastrosimples.CadastroSimples.Usuarios.UsuarioModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contatos")
public class ContatoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String celular;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioModel usuario;
    
    public ContatoModel() {
    }

}
