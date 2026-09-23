package com.algaworks.estoque;

import java.util.List;
import java.util.Optional;

public class MainMatch {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

//        boolean temProdutoNoEstoque = produtos.stream()
//                .peek(System.out::println)
//                .anyMatch(Produto::temEstoque);
//        System.out.println(temProdutoNoEstoque);

//        boolean todosProdutosTemEstoque = produtos.stream()
//                .peek(System.out::println)
//                .allMatch(Produto::temEstoque);
//
//        System.out.println(todosProdutosTemEstoque);

        boolean nenhumProdutoPossueEstoque = produtos.stream()
                .peek(System.out::println)
                .noneMatch(Produto::temEstoque);

        System.out.println(nenhumProdutoPossueEstoque);

    }
}

