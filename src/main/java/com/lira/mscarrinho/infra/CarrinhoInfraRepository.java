package com.lira.mscarrinho.infra;

import com.lira.mscarrinho.domain.Carrinho;
import com.lira.mscarrinho.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoInfraRepository implements CarrinhoRepository {
    private final CarrinhoSpringDataJPARepository carrinhoSpringDataJPARepository;

    @Override
    public Carrinho saveCarrinho(Carrinho carrinho) {
        log.info("[start] CarrinhoInfraRepository - saveCarrinho");
        Carrinho carrinhoSalvo = carrinhoSpringDataJPARepository.save(carrinho);
        log.info("[finish] CarrinhoInfraRepository - saveCarrinho");
        return carrinhoSalvo;
    }
}
