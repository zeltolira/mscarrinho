package com.lira.mscarrinho.application.service;

import com.lira.mscarrinho.application.api.requestItem.ItemCarrinhoRequest;
import com.lira.mscarrinho.application.api.responseItem.ItemCarrinhoResponse;
import com.lira.mscarrinho.client.ProdutoClient;
import com.lira.mscarrinho.domain.CalculadoraDeDesconto;
import com.lira.mscarrinho.domain.Carrinho;
import com.lira.mscarrinho.domain.ItemCarrinho;
import com.lira.mscarrinho.domain.Produto;
import com.lira.mscarrinho.repository.CarrinhoRepository;
import com.lira.mscarrinho.repository.ItemCarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoApplicationService implements ItemCarrinhoService {
    private final ProdutoClient produtoClient;
    private final CarrinhoRepository carrinhoRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final CalculadoraDeDesconto calculadoraDeDesconto;

    @Override
    public ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoApplicationService - postItemCarrinho");
        Produto produto = produtoClient.getProdutoPorId(itemCarrinhoRequest.getIdProduto());
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(itemCarrinhoRequest.getIdCarrinho());
        ItemCarrinho itemCarrinho = new ItemCarrinho(produto, carrinho, itemCarrinhoRequest);
        BigDecimal subtotalComDesconto = calculadoraDeDesconto.calcular(
                produto.getPromocao(),
                produto.getPrecoProduto(),
                itemCarrinhoRequest.getQuantidade()
        );
        itemCarrinho.definirSubtotal(subtotalComDesconto);
        ItemCarrinho itemSalvo = itemCarrinhoRepository.salvarItemCarrinho(itemCarrinho);
        carrinho.adicionarItem(itemCarrinho);
        carrinhoRepository.saveCarrinho(carrinho);
        log.info("[finish] ItemCarrinhoApplicationService - postItemCarrinho");
        return new ItemCarrinhoResponse(itemSalvo);
    }
}
