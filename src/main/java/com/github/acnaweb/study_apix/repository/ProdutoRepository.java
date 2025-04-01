package com.github.acnaweb.study_apix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.acnaweb.study_apix.model.Produto;

//Esse arquivo de ProdutoRepository serve apenas para acessar e manipular os dados da entidade 'Produto' no banco de dados.
//O arquivo parece vazio porque está sendo usando o Spring Data JPA,
//que já fornece uma implementação automática para os métodos básicos de manipulação de dados (como save, findAll, findById, etc.).
//que são como o INSERT, DELETE e FIND no SQL




@Repository //indica que essa interface é um componente Spring responsável por acessar o banco de dados.
public interface ProdutoRepository 
            extends JpaRepository<Produto, Long> {
            //Aqui eu to dando extend de JpaRepository, quem com isso eu consigo utilizar as funções de save, findAll, findById quando chamar ProdutoRepository em outras classes
}
