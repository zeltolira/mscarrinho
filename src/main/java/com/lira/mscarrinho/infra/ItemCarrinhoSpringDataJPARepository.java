package com.lira.mscarrinho.infra;

import com.lira.mscarrinho.domain.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoSpringDataJPARepository extends JpaRepository <ItemCarrinho, Long> {
    ItemCarrinho save(ItemCarrinho itemCarrinho);
}
