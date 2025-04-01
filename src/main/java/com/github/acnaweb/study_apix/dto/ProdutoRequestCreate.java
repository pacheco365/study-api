package com.github.acnaweb.study_apix.dto;

public class ProdutoRequestCreate {
    //Aqui estamos criando uma classe que vai ser chamada posteriormente que vai receber apenas uma string
    //e ja adiciona no banco de dados com um id
    // DTO = Data Transfer Objects
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
