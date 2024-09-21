package com.example.pedidos.service;

import com.example.pedidos.model.ItemPedido;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.model.Produto;
import com.example.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public BigDecimal calcularValorTotal(Pedido pedido){
        return pedido.getItems().stream()
                .map(this::calcularValorDeItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularValorDeItem(ItemPedido item){
        Produto produto = produtoService.getById(item.getProdutoId());
        return produto.getPreco().multiply(new BigDecimal(item.getQuantidade()));
    }
}
