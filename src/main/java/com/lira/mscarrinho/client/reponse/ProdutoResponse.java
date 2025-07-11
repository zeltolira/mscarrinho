package com.lira.mscarrinho.client.reponse;

import com.lira.mscarrinho.domain.StatusProduto;
import com.lira.mscarrinho.domain.TipoPromocao;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutoResponse {

        private UUID idProduto;
        private String nomeProduto;
        private BigDecimal precoProduto;
        private StatusProduto statusProduto;
        private TipoPromocao promocao;

}
