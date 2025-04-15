package com.github.acnaweb.study_apix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.dto.ProdutoRequestUpdate;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService { //Essa classe ta sendo responsável por adicionar novos produtos dentro do banco de dados

    @Autowired //Autowired serve pra indicar jusatmente isso que escrevi abaixo, sem precisar do 'this.produtoRepository = new ProdutoRepository'
    private ProdutoRepository produtoRepository; //Aqui o Spring injeta uma instância de ProdutoRepository em produtoRepository, que agora pode acessar o save, findAll, etc.


    //Esse método é responsável por atualizar o produto, ele recebe o id do produto que queremos atualizar e o dto que contém os dados atualizados
    public Optional<Produto> update(Long id,
                            ProdutoRequestUpdate dto) {
    return produtoRepository.findById(id)
                .map(produto -> { //Aqui estamos pegando o produto que queremos atualizar, e se ele existir, vamos fazer o update dele
                    produto.setNome(dto.getNome());
                    return produtoRepository.save(produto);
                });
    }


    //Esse método é responsável por criar um novo produto, ele recebe o dto que contém os dados do novo produto
    public Produto save(ProdutoRequestCreate dto) {
                
        Produto produto = new Produto(); //Aqui estamos 'resetando' Produto, com isso id e nome ficam null
        produto.setNome(dto.getNome());//E com isso estamos dando dto.getNome que é a string que vai ser recebida, o 'id' ja esta sendo gerado em 'Produto' com o @GeneratedValue

        return produtoRepository.save(produto);
    }

    //Método que retorna tudo que tem no banco de dados, no caso produtos
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    //Método que retorna um produto específico, ele recebe o id do produto que queremos encontrar
    public Optional<Produto> findById(Long id) {
           return produtoRepository.findById(id);
    }

    //Método que deleta um produto específico, ele recebe o id do produto que queremos deletar
    public boolean deleteById(Long id){
        if (produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
