package com.lira.mscarrinho.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "id_produto", nullable = false)
    private UUID idProduto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    @JsonIgnore
    private Carrinho carrinho;

    private int quantidade;
    private BigDecimal subtotal;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;
}
