package com.prova.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.crud.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}