package com.example.pedidos.controller;
import com.example.pedidos.model.ImpostoResponsePayload;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.ImpostoService;
import com.example.pedidos.service.NotaFiscalService;
import com.example.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class pedidoController {
    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    private final NotaFiscalService notaFiscalService;
    @PostMapping
    public ResponseEntity create(@RequestBody Pedido pedido){
        BigDecimal totalImposto = impostoService.getTotalImposto(pedido).totalImposto();
//        BigDecimal valorSemImposto = pedidoService.calcularValorTotal(pedido);
        pedido.setTotalimposto(totalImposto);
//        pedido.setValorTotalSemImposto(valorSemImposto);
//        pedido.setValorTotalComImposto(valorSemImposto.add(totalImposto));
        System.out.println("TotalImposto: " + totalImposto);
        Pedido saved = pedidoService.salvar(pedido);
//        notaFiscalService.emitir(pedido.getId());
        return ResponseEntity.ok(Map.of("pedido", saved));
    }
}
