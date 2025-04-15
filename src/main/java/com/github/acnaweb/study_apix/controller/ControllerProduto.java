package com.github.acnaweb.study_apix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.dto.ProdutoRequestUpdate;
import com.github.acnaweb.study_apix.dto.ProdutoResponse;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.service.ProdutoService;

import java.util.List;

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


    //Método que atualiza um produto, ele recebe o id do produto que queremos atualizar e o dto que contém os dados atualizados
    //O método é chamado quando uma requisição PUT é feita para o endpoint /produtos/{id}, onde {id} é o ID do produto a ser atualizado.
    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponse> update(
				@PathVariable Long id, 
				@RequestBody ProdutoRequestUpdate dto) {
               
        return produtoService.update(id, dto)
                    .map(produto -> { 
                        ProdutoResponse response = new ProdutoResponse();
                        response.setId(produto.getId());
                        response.setNome(produto.getNome());
                        return ResponseEntity.status(200).body(response);
                    })                  
                    .orElse(ResponseEntity.notFound().build());        
    }


    //Método que retorna tudo que tem no banco de dados, no caso produtos
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() { //List<Produtos> é o tipo que iremos retornar nesse método
        List<Produto> produtos = produtoService.findAll(); //criamos uma lista generica
        return ResponseEntity.status(200).body(produtos);
    }


    //Método que retorna um produto específico, ele recebe o id do produto que queremos encontrar
    @GetMapping("{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) { //@PathVariable informa que a variavel id vai ser recebida pela url
        return produtoService.findById(id)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }


    //Método que deleta um produto específico, ele recebe o id do produto que queremos deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = produtoService.deleteById(id);

        if (result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
