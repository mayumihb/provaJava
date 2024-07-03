package com.prova.crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.crud.Model.Produto;
import com.prova.crud.Repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProduto(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto cadastrarProduto(Produto Produto) {
        return produtoRepository.save(Produto);
    }

    public Optional<Produto> atualizarProduto(Long id, Produto Produto) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            Produto.setId(id);
            return Optional.of(produtoRepository.save(Produto));
        }
        return Optional.empty();
    }

    public boolean deletarProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}