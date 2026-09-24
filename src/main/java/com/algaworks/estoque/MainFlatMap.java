package com.algaworks.estoque;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainFlatMap {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        produtos.stream()
                .filter(Produto::temEstoque)
                .flatMap(produto -> produto.getCategorias().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("-------------------------------");

        Set<Categoria> categorias = new HashSet<>();
        for (Produto produto : produtos) {
            if(produto.temEstoque()){
                categorias.addAll(produto.getCategorias());
            }
        }
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }
}

