package com.example.pedidos.controller;
import com.example.pedidos.model.ImpostoResponsePayload;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.ImpostoService;
import com.example.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class pedidoController {
    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    @PostMapping
    public ResponseEntity create(@RequestBody Pedido pedido){
        ImpostoResponsePayload impostoResponsePayload = impostoService.getTotalImposto(pedido);
        System.out.println("TotalImposto: " + impostoResponsePayload);

        pedidoService.salvar(pedido);
        return null;
    }
}
