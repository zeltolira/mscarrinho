package com.lira.mscarrinho.application.service;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import com.lira.mscarrinho.application.api.response.CarrinhoDetalhadoResponse;
import com.lira.mscarrinho.application.api.response.CarrinhoResponse;
import com.lira.mscarrinho.domain.Carrinho;
import com.lira.mscarrinho.handler.APIException;
import com.lira.mscarrinho.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
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
    @Override
    public CarrinhoDetalhadoResponse getCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoApplicationService - getCarrinhoById");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
        log.info("[finish] CarrinhoApplicationService - getCarrinhoById");
        return new CarrinhoDetalhadoResponse(carrinho);
    }
    @Override
    public void deleteCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoApplicationService - deleleCarrinhoById");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
//        if (!carrinho.getItens().isEmpty()){
//            throw APIException.build(HttpStatus.NOT_FOUND, "Carrinho não pode ser excluído porque contém itens.");
//        }
        carrinhoRepository.deleteCarrinho(carrinho);
        log.info("[finish] CarrinhoApplicationService - deleleCarrinhoById");

    }
}
