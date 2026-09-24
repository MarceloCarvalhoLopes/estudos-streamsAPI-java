package com.algaworks.estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class MainOptional {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();
//        List<Produto> produtos = new ArrayList<>();

        OptionalInt maiorQuantidadeOptional = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(Integer::max);

        int maiorQuantidade = maiorQuantidadeOptional
                .orElseThrow(() -> new RuntimeException("Quantidde não encontrada"));

        System.out.println("TOTAL DE PRODUTOS: " + maiorQuantidade);


    }
}

