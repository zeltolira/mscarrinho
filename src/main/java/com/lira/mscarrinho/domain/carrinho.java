package com.lira.mscarrinho.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "carrinho")
public class carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ItemCarrinho> itens = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;
}
