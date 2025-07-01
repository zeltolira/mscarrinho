package com.lira.mscarrinho.repository;

import com.lira.mscarrinho.domain.Carrinho;

public interface CarrinhoRepository {

    Carrinho saveCarrinho(Carrinho carrinho);
    Carrinho getCarrinhoById(Long idCarrinho);
    void deleteCarrinho(Carrinho carrinho);
}
