package com.github.acnaweb.study_apix.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity //marcando a classe como JPA, isso significa que a classe será mapeada para uma tabela no banco de dados.
public class Produto {

    //Aqui estamos definindo o modelo do produto, ou seja, vai receber id e nome, do tipo Long e nome respectivamente
    @Id //Aqui definimos que esse campo é a primary key no banco de dados
    @GeneratedValue //indica que o valor da chave primária será gerado automaticamente.
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
