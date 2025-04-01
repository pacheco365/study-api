package com.github.acnaweb.study_apix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.service.ProdutoService;

@RestController //Isso indica que é um Controlador RESTful, que faz requisições como GET, POST, DELETE e retornar isso
@RequestMapping("produtos") //Isso significa que todos os métodos dessa classe terão o prefixo /produtos no caminho da URL, O método anotado com @PostMapping será acessado em POST /produtos
public class ControllerProduto {

    @Autowired //Autowired serve pra indicar que produtoService acessa/vira ProdutoService
    private ProdutoService produtoService;

    @PostMapping //indica que este método será chamado quando uma requisição POST for feita para o endpoint /produtos.
    public ResponseEntity<Produto> //ResponseEntity controi as respostas HTTP(requisições). <Produto> indica que o corpo da resposta conterá um objeto do tipo Produto.
                create(@RequestBody ProdutoRequestCreate dto) { //@RequestBody indica que o corpo da requisição (geralmente JSON) será convertido em um objeto do tipo ProdutoRequestCreate.

        Produto produto = produtoService.save(dto); //dando o post no banco de dados com o save 

        return ResponseEntity.status(201).body(produto); //Indica que funcionou
    }

    @PutMapping //Put é a requisição para fazer um update no banco de dados
    public ResponseEntity<String> update() { //Nesse caso o update vai ser apenas a string ja que o id é fixo
        return ResponseEntity.status(200).body("Produto atualizado");
    }

    @GetMapping //Get é a requisição para achar algo nesse banco de dados
    public ResponseEntity<String> find() {
        return ResponseEntity.status(200).body("Produto encontrado"); 
    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        return ResponseEntity.status(204).build();//Aqui ao invés de body estamos usando build pq no delete não precisa retornar um corpo como resposta
    }

}
