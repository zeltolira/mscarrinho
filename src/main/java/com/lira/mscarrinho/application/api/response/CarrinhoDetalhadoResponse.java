package com.lira.mscarrinho.application.api.response;

import com.lira.mscarrinho.domain.Carrinho;

import java.math.BigDecimal;
import java.util.List;

public class CarrinhoDetalhadoResponse {
    private Long idCarrinho;
//    private List<ItemCarrinho> itens;
    private BigDecimal total;

    public CarrinhoDetalhadoResponse(Carrinho carrinho) {
        this.idCarrinho = carrinho.getIdCarrinho();
//        this.itens = carrinho.getItens();
        this.total = carrinho.getTotal();
    }
}
