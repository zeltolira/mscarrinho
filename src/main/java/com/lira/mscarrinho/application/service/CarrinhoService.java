package com.lira.mscarrinho.application.service;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import com.lira.mscarrinho.application.api.response.CarrinhoDetalhadoResponse;
import com.lira.mscarrinho.application.api.response.CarrinhoResponse;

public interface CarrinhoService {
    CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest);
    CarrinhoDetalhadoResponse getCarrinhoById(Long idCarrinho);
}
