package com.github.acnaweb.study_apix.dto;


//ProdutoResponse é o corpo da resposta que vai ser retornada para o cliente quando ele fizer uma requisição para a API
//Isso serve para que no return ele retorne o que foi criado ou atualizado no banco de dados
public class ProdutoResponse {
    private Long id;
    
    private String nome;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
