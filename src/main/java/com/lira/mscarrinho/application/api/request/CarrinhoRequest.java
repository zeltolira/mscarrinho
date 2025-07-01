package com.lira.mscarrinho.application.api.request;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class CarrinhoRequest {
//    private List<ItemCarrinho> itens = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;
    private LocalDateTime dataHoraCriacao;
}
