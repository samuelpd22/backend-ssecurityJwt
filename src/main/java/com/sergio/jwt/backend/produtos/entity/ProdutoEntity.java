package com.sergio.jwt.backend.produtos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos_auth")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cpf;

    private String endereco;

    private String telefone;

    private String email;
}
