package com.lira.mscarrinho.application.service;

import com.lira.mscarrinho.application.api.requestItem.ItemCarrinhoRequest;
import com.lira.mscarrinho.application.api.responseItem.ItemCarrinhoResponse;

public interface ItemCarrinhoService {
    ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest);
}
