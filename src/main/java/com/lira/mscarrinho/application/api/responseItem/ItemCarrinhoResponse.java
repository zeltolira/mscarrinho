package com.lira.mscarrinho.application.api.responseItem;

import com.lira.mscarrinho.domain.ItemCarrinho;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ItemCarrinhoResponse {
    private Long idItemCarrinho;
    private UUID idProduto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemCarrinhoResponse(ItemCarrinho itemCarrinho) {
        this.idItemCarrinho = itemCarrinho.getIdItemCarrinho();
        this.idProduto = itemCarrinho.getProduto().getIdProduto();
        this.quantidade = itemCarrinho.getQuantidade();
        this.subtotal = itemCarrinho.getSubtotal();
    }
}
