package com.algaworks.estoque;

import java.util.List;
import java.util.stream.IntStream;

public class MainReduce {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        int totalEstoque = produtos.stream()

                .mapToInt(Produto::getQuantidade)
                .reduce(0, Integer::sum);

        System.out.println("TOTAL DE PRODUTOS: " + totalEstoque);


    }
}

