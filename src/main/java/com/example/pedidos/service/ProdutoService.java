package com.example.pedidos.service;

import com.example.pedidos.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    public Produto getById(Long id){
        var serverUrl = String.format("http://localhost:8083/%d", id);
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Produto.class).getBody();
    }
}
