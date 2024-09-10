package com.example.pedidos.service;

import com.example.pedidos.model.ImpostoResponsePayload;
import com.example.pedidos.model.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;


//@Service
//public class ImpostoService {

//    private final WebClient webClient;
//
//    public ImpostoService(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl("http://localhost:8085").build();
//    }
//
//    public ImpostoResponsePayload getTotalImposto(Pedido pedido) {
//        return webClient.post()
//                .uri("/")  // Caminho no servidor, ou você pode passar o caminho completo aqui
//                .bodyValue(pedido)  // O corpo do pedido
//                .retrieve()  // Executa a chamada HTTP
//                .bodyToMono(ImpostoResponsePayload.class)  // Converte o corpo da resposta para ImpostoResponsePayload
//                .block();  // Converte a resposta para estilo sincrônico (não reativo)
//    }
//}


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