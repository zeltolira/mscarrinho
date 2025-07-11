package com.lira.mscarrinho.client;

import com.lira.mscarrinho.client.reponse.ProdutoResponse;
import com.lira.mscarrinho.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoClient {

    private final WebClient.Builder builder;


    public Produto buscarProdutoPorId(UUID idProduto) {
        ProdutoResponse response = builder
                .baseUrl("http://produto-service")
                .build()
                .get()
                .uri("/v1/produto/{id}", idProduto)
                .retrieve()
                .bodyToMono(ProdutoResponse.class)
                .block();

        if (response == null) {
            throw new RuntimeException("Produto não encontrado");
        }

        return new Produto(
                response.getIdProduto(),
                response.getNomeProduto(),
                response.getPrecoProduto(),
                response.getStatusProduto(),
                response.getPromocao()
        );
    }
}