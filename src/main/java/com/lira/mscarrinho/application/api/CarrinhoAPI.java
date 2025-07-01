package com.lira.mscarrinho.application.api;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import com.lira.mscarrinho.application.api.response.CarrinhoRespponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoRespponse postCarrinho(@Valid @RequestBody CarrinhoRequest carrinhoRequest);
}
