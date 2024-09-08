package com.example.pedidos.service;

import com.example.pedidos.model.ImpostoResponsePayload;
import com.example.pedidos.model.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ImpostoService {
    public ImpostoResponsePayload getTotalImposto(Pedido pedido){
        var serverUrl = "http://localhost:8085";
        RestClient restClient = RestClient.create();
        return restClient.post()
                .uri(serverUrl)
                .body(pedido)
                .retrieve()
                .toEntity(ImpostoResponsePayload.class).getBody();
    }
}