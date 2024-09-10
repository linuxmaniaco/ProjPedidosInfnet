package com.example.pedidos.service;

import com.example.pedidos.model.Pedido;
import com.example.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
//    Pedido pedido = new Pedido();
    public Pedido salvar(Pedido pedido){

        pedido.setId(new ObjectId().getTimestamp()); // Define um novo ID único
        return pedidoRepository.save(pedido);
    }
}
