package com.lira.mscarrinho.promocao;

import com.lira.mscarrinho.domain.TipoPromocao;

import java.math.BigDecimal;

public interface DescontoStrategy {
    BigDecimal calcularDesconto(BigDecimal preco, int quantidade);
    TipoPromocao getTipo();
    default boolean isAplicavel(int quantidade){
        return true;
    }
}
