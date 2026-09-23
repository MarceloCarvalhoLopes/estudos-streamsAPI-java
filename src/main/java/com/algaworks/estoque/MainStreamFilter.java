package com.algaworks.estoque;

import java.util.List;
import java.util.stream.Stream;

public class MainStreamFilter {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        Stream<Produto> stream = produtos.stream();
        Stream<Produto> streamComEstoque = stream
                .filter(Produto::temEstoque);

        Stream<Produto> streamComEstoqueInativo = streamComEstoque
                .filter(Produto::isInativo);

    }
}

