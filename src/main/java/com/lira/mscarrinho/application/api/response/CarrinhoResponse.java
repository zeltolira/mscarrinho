package com.lira.mscarrinho.application.api.response;

import com.lira.mscarrinho.domain.Carrinho;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Data
public class CarrinhoResponse {
    private Long idCarrinho;
//    private List<ItemCarrinho> itens;
    private BigDecimal total;

    public CarrinhoResponse(Carrinho carrinho) {
        this.idCarrinho = carrinho.getIdCarrinho();
//        this.itens = carrinho.getItens();
        this.total = carrinho.getTotal();
    }
}
