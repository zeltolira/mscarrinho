package com.lira.mscarrinho.infra;

import com.lira.mscarrinho.domain.Carrinho;
import com.lira.mscarrinho.handler.APIException;
import com.lira.mscarrinho.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.HttpStatus;
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
    @Override
    public Carrinho getCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoInfraRepository - carrinhogetCarrinhoById");
        Carrinho carrinho = carrinhoSpringDataJPARepository.findById(idCarrinho)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encotrado para o ID " + idCarrinho));
        log.info("[finish] CarrinhoInfraRepository - carrinhogetCarrinhoById");
        return carrinho;
    }
}
