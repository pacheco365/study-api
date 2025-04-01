package com.github.acnaweb.study_apix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.repository.ProdutoRepository;

@Service
public class ProdutoService { //Essa classe ta sendo responsável por adicionar novos produtos dentro do banco de dados

    @Autowired //Autowired serve pra indicar jusatmente isso que escrevi abaixo, sem precisar do 'this.produtoRepository = new ProdutoRepository'
    private ProdutoRepository produtoRepository; //Aqui o Spring injeta uma instância de ProdutoRepository em produtoRepository, que agora pode acessar o save, findAll, etc.

    public Produto save(ProdutoRequestCreate dto) { //a variavel 'dto' é a instância que contém os dados enviados para o método save.
                
        Produto produto = new Produto(); //Aqui estamos 'resetando' Produto, com isso id e nome ficam null
        produto.setNome(dto.getNome());//E com isso estamos dando dto.getNome que é a string que vai ser recebida, o 'id' ja esta sendo gerado em 'Produto' com o @GeneratedValue

        return produtoRepository.save(produto); //Aqui estamos dando o INSERT no banco de dados
    }

}
