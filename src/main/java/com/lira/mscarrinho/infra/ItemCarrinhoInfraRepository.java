package com.lira.mscarrinho.infra;

import com.lira.mscarrinho.client.ProdutoClient;
import com.lira.mscarrinho.domain.Carrinho;
import com.lira.mscarrinho.domain.ItemCarrinho;
import com.lira.mscarrinho.domain.Produto;
import com.lira.mscarrinho.handler.APIException;
import com.lira.mscarrinho.repository.CarrinhoRepository;
import com.lira.mscarrinho.repository.ItemCarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoInfraRepository implements ItemCarrinhoRepository {
    private final ItemCarrinhoSpringDataJPARepository itemCarrinhoSpringDataJPARepository;
    private final ProdutoClient produtoClient;
    private final CarrinhoRepository carrinhoRepository;

    @Override
    public ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho) {
        log.info("[start] ItemCarrinhoInfraRepository - salvarItemCarrinho");
        Produto produto = produtoClient.getProdutoById(itemCarrinho.getProduto().getIdProduto());
        if (produto == null){
            throw APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(itemCarrinho.getCarrinho().getIdCarrinho());
        if (carrinho == null){
            throw APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado");
        }
        ItemCarrinho itemSalvo = itemCarrinhoSpringDataJPARepository.save(itemCarrinho);
        log.info("[finish] ItemCarrinhoInfraRepository - salvarItemCarrinho");
        return itemSalvo;
    }
}
