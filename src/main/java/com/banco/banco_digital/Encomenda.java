package com.banco.banco_digital;

import jakarta.persistence.*;

@Entity
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String modeloTenis;
    private String cep;

    // Getters e setters
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getModeloTenis() { return modeloTenis; }
    public void setModeloTenis(String modeloTenis) { this.modeloTenis = modeloTenis; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}