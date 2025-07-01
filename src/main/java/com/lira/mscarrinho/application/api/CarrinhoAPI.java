package com.lira.mscarrinho.application.api;

import com.lira.mscarrinho.application.api.request.CarrinhoRequest;
import com.lira.mscarrinho.application.api.response.CarrinhoDetalhadoResponse;
import com.lira.mscarrinho.application.api.response.CarrinhoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCarrinho(@Valid @RequestBody CarrinhoRequest carrinhoRequest);

    @GetMapping(value = "/{idCarrinho}")
    @ResponseStatus(code = HttpStatus.OK)
    CarrinhoDetalhadoResponse getCarrinhoById(@PathVariable Long idCarrinho);

    @DeleteMapping(value = "/{idCarrinho}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteCarrinhoById(@PathVariable Long idCarrinho);
}
