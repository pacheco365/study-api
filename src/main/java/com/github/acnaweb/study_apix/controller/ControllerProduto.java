package com.github.acnaweb.study_apix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PutMapping
    public ResponseEntity<String> update() { //Nesse caso o update vai ser apenas a string ja que o id é fixo
        return ResponseEntity.status(200).body("Produto atualizado");
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() { //List<Produtos> é o tipo que iremos retornar nesse método
        List<Produto> produtos = produtoService.findAll(); //criamos uma lista generica
        return ResponseEntity.status(200).body(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) { //@PathVariable informa que a variavel id vai ser recebida pela url
        return produtoService.findById(id)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = produtoService.deleteById(id);

        if (result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
