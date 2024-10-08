package com.example.pedidos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "pedidos")
public class Pedido {
    @Id
    private String id;
    private List<ItemPedido> items;
    private BigDecimal totalimposto;
    private BigDecimal valorTotalSemImposto;
    private BigDecimal valorTotalComImposto;
}