package com.cadastrosimples.CadastroSimples.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contatos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContatoModel {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11)
    @NotNull
    @NotBlank
    @Size(max=11)
    private String celular;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    @JsonBackReference
    private UsuarioModel usuario;
}
