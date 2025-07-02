package com.lira.mscarrinho.application.api;

import com.lira.mscarrinho.application.api.requestItem.ItemCarrinhoRequest;
import com.lira.mscarrinho.application.api.responseItem.ItemCarrinhoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/item-carrinho")
public interface ItemCarrinhoApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ItemCarrinhoResponse postItemCarrinho(@RequestBody @Valid ItemCarrinhoRequest itemCarrinhoRequest);
}
