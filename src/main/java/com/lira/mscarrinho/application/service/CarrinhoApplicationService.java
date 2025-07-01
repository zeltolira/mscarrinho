package com.lira.mscarrinho.application.service;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import com.lira.mscarrinho.application.api.response.CarrinhoResponse;
import com.lira.mscarrinho.domain.Carrinho;
import com.lira.mscarrinho.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;

    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        Carrinho carrinho = carrinhoRepository.saveCarrinho(new Carrinho(carrinhoRequest));
        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return new CarrinhoResponse(carrinho);
    }
}
