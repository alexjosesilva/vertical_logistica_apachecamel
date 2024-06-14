package com.example.vertical_logistica_apachecamel.route;

import com.example.vertical_logistica_apachecamel.processor.PedidoProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class PedidoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Configurar o componente REST
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.auto);

        // Definição da rota REST
        rest("/api")
                .post("/process")
                .consumes("text/plain")
                .produces("application/json")
                .to("direct:processPedidos");

        // Rota Camel para processamento dos pedidos
        from("direct:processPedidos")
                .process(new PedidoProcessor());
    }
}
