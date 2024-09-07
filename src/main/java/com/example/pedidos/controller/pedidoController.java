package com.example.pedidos.controller;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class pedidoController {
    private final PedidoService pedidoService;
    @PostMapping
    public ResponseEntity create(@RequestBody Pedido pedido){

        pedidoService.salvar(pedido);

        return null;
    }
}
