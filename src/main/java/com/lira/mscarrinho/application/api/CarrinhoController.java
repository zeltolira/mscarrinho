package com.lira.mscarrinho.application.api;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import com.lira.mscarrinho.application.api.response.CarrinhoResponse;
import com.lira.mscarrinho.application.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CarrinhoController implements CarrinhoAPI {

    private final CarrinhoService carrinhoService;

    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoController - postCarrinho");
        CarrinhoResponse carrinho = carrinhoService.postCarrinho(carrinhoRequest);
        log.info("[finish] CarrinhoController - postCarrinho");
        return carrinho;
    }
}
