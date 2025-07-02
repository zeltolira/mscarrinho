package com.lira.mscarrinho.application.api.requestItem;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class ItemCarrinhoRequest {
    @NotNull
    private UUID idProduto;
    @NotNull
    private Long idCarrinho;
    @NotNull
    private int quantidade;
}
