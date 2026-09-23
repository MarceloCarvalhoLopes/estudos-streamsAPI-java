package com.algaworks.estoque;

import java.util.List;

public class MainPeek {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        produtos.stream()
                .peek(produto -> produto.setNome(produto.getNome().toUpperCase()))
                .peek(p->System.out.println("Antes do temEstoque: "+p))
                .filter(Produto::temEstoque)
                .peek(p->System.out.println("Depois do temEstoque: "+p))
                .filter(Produto::isInativo)
                .forEach(produto -> {
                    System.out.println("Ativando: " + produto);
                    produto.ativar();
                });



//        Stream<Produto> stream = produtos.stream();
//        Stream<Produto> streamComEstoque = stream
//                .filter(Produto::temEstoque);
//
//        Stream<Produto> streamComEstoqueInativo = streamComEstoque
//                .filter(Produto::isInativo);
//
//        streamComEstoqueInativo.forEach(produto -> {
//            produto.ativar();
//            System.out.println(produto);
//        });
    }
}

