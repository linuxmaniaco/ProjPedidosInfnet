package com.example.pedidos.service.clients;

import com.example.pedidos.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("PRODUTO-SERVICE")
public interface ProdutoClient {
    @GetMapping("/")
    Produto getById(@PathVariable("id") Long id);
}
