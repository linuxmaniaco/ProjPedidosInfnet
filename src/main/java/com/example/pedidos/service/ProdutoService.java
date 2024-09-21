package com.example.pedidos.service;

import com.example.pedidos.model.Produto;
import com.example.pedidos.service.clients.ProdutoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoClient produtoClient;

    public Produto getById(Long id){
        System.out.println("ESTOU AQUI");
        return produtoClient.getById(id);
//        var serverUrl = String.format("http://localhost:8083/%d", id);
//        RestClient restClient = RestClient.create();
//        return restClient
//                .get()
//                .uri(serverUrl)
//                .retrieve()
//                .toEntity(Produto.class).getBody();
    }
}
