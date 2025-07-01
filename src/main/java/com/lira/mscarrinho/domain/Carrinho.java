package com.lira.mscarrinho.domain;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;

//    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ItemCarrinho> itens = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.total = BigDecimal.ZERO;
        this.dataHoraCriacao = LocalDateTime.now();

//        if (carrinhoRequest.getItens() != null){
//            for (ItemCarrinho item : carrinhoRequest.getItens()){
//                this.adicionarItem(item);
//            }
//        }
    }
}
