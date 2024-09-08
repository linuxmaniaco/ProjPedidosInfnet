package com.example.pedidos.service;

import com.example.pedidos.model.Pedido;
import com.example.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
}
