package com.lira.mscarrinho.application.api;

import com.lira.mscarrinho.application.api.requestItem.ItemCarrinhoRequest;
import com.lira.mscarrinho.application.api.responseItem.ItemCarrinhoResponse;
import com.lira.mscarrinho.application.service.ItemCarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoController implements ItemCarrinhoApi {
    private final ItemCarrinhoService itemCarrinhoService;

    @Override
    public ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoController - postItemCarrinho");
        ItemCarrinhoResponse itemCarrinho = itemCarrinhoService.postItemCarrinho(itemCarrinhoRequest);
        log.info("[finish] ItemCarrinhoController - postItemCarrinho");
        return itemCarrinho;
    }
}
