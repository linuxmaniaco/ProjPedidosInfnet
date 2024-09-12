package com.example.pedidos.service;

import com.example.pedidos.model.ImpostoResponsePayload;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.clients.ImpostoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    private final ImpostoClient impostoClient;

    public ImpostoResponsePayload getTotalImposto(Pedido pedido){
        return impostoClient.calcularImposto(pedido);

//        var serverUrl = "http://localhost:8085";
//        RestClient restClient = RestClient.create();
//        return restClient.post()
//                .uri(serverUrl)
//                .body(pedido)
//                .retrieve()
//                .toEntity(ImpostoResponsePayload.class).getBody();
    }
}