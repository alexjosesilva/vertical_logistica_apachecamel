package com.example.vertical_logistica_apachecamel.processor;
import com.example.vertical_logistica_apachecamel.model.Order;
import com.example.vertical_logistica_apachecamel.model.Pedido;
import com.example.vertical_logistica_apachecamel.model.Product;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.text.SimpleDateFormat;
import java.util.*;
public class PedidoProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        String[] lines = body.split("\n");

        Map<Integer, Pedido> pedidosMap = new HashMap<>();

        for (String line : lines) {
            int userId = Integer.parseInt(line.substring(0, 10).trim());
            String name = line.substring(10, 55).trim();
            int orderId = Integer.parseInt(line.substring(55, 65).trim());
            int productId = Integer.parseInt(line.substring(65, 75).trim());
            double value = Double.parseDouble(line.substring(75, 87).trim());
            String date = line.substring(87, 95).trim();

            Pedido pedido = pedidosMap.getOrDefault(userId, new Pedido());
            pedido.setUserId(userId);
            pedido.setName(name);

            Order order = pedido.getOrders().stream()
                    .filter(o -> o.getOrderId() == orderId)
                    .findFirst()
                    .orElse(new Order());
            order.setOrderId(orderId);
            order.setDate(new SimpleDateFormat("yyyyMMdd").parse(date).toString());
            order.setTotal(order.getTotal() + value);

            Product product = new Product();
            product.setProductId(productId);
            product.setValue(value);

            order.getProducts().add(product);
            pedido.getOrders().add(order);

            pedidosMap.put(userId, pedido);
        }

        exchange.getIn().setBody(new ArrayList<>(pedidosMap.values()));
    }
}
