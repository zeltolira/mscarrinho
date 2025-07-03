package com.lira.mscarrinho.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lira.mscarrinho.application.api.requestItem.ItemCarrinhoRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Log4j2
@NoArgsConstructor
@Table(name = "itemCarrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemCarrinho;

    @Transient
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    @JsonIgnore
    private Carrinho carrinho;

    private int quantidade;
    private BigDecimal subtotal;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

    public ItemCarrinho(Produto produto, Carrinho carrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        this.produto = produto;
        this.carrinho = carrinho;
        this.setQuantidade(itemCarrinhoRequest.getQuantidade());
        this.dataHoraCriacao = LocalDateTime.now();
    }

    public void definirSubtotal(BigDecimal subtotaComDesconto) {
        this.subtotal = subtotal;
    }
}
