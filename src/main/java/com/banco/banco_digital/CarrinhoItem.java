package com.banco.banco_digital;

public class CarrinhoItem {
    private String nome;

    public CarrinhoItem() {}

    public CarrinhoItem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}