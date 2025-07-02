package com.lira.mscarrinho.application.api.responseItem;

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
}
