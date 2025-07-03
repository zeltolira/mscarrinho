package com.lira.mscarrinho.client;

import com.lira.mscarrinho.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoClient {

    private final WebClient.Builder builder;

    public Produto getProdutoPorId(UUID idProduto){
        return builder
                .baseUrl("http://produto-service")
                .build()
                .get()
                .uri("/v1/produto/{id}", idProduto)
                .retrieve()
                .bodyToMono(Produto.class)
                .block();
    }


    public Produto getProdutoById(UUID idProduto) {
        return builder
                .baseUrl("http://produto-service")
                .build()
                .get()
                .uri("/v1/produto/{id}", idProduto)
                .retrieve()
                .bodyToMono(Produto.class)
                .block();
    }
}