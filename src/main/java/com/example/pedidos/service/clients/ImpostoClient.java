package com.example.pedidos.service.clients;

import com.example.pedidos.model.ImpostoResponsePayload;
import com.example.pedidos.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("IMPOSTO-SERVICE")
public interface ImpostoClient {
    @PostMapping("/")
    ImpostoResponsePayload calcularImposto(@RequestBody Pedido pedido);
}
