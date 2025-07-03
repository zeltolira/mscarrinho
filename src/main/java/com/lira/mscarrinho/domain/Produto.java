package com.lira.mscarrinho.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Produto {
    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    private StatusProduto statusProduto;
    private TipoPromocao promocao;

}
