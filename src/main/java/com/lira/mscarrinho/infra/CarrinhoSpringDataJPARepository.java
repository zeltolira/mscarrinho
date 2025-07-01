package com.lira.mscarrinho.infra;

import com.lira.mscarrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoSpringDataJPARepository extends JpaRepository <Carrinho,Long> {
}
