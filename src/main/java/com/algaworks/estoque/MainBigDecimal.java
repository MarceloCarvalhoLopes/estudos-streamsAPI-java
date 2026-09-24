package com.algaworks.estoque;

import java.math.BigDecimal;
import java.util.List;

public class MainBigDecimal {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

//        BigDecimal valorEmEstoque = produtos.stream()
//                .map(Produto::getValorEstoque)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        System.out.println("Valor em estoque: " + valorEmEstoque);

        BigDecimal valorEmEstoque = produtos.stream()
                .reduce(BigDecimal.ZERO, (subtotal, produto) -> {
                    BigDecimal valorEstoqueProduto = produto.getPreco()
                            .multiply(new BigDecimal(produto.getQuantidade()));
                    return subtotal.add(valorEstoqueProduto);
                }, BigDecimal::add);

        System.out.println("Valor em estoque: " + valorEmEstoque);

    }
}

