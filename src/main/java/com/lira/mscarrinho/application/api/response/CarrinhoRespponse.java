package com.lira.mscarrinho.application.api.response;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Data
public class CarrinhoRespponse {
    private Long idCarrinho;
//    private List<ItemCarrinho> itens;
    private BigDecimal total;
}
