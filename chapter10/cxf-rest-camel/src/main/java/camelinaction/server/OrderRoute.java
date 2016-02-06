package camelinaction.server;

import camelinaction.OrderService;
import org.apache.camel.builder.RouteBuilder;

public class OrderRoute extends RouteBuilder {

    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void configure() throws Exception {
        from("direct:getOrder").routeId("getOrder")
            .bean(orderService, "getOrder");

        from("direct:updateOrder").routeId("updateOrder")
            .bean(orderService, "updateOrder");

        from("direct:createOrder").routeId("createOrder")
            .bean(orderService, "createOrder");

        from("direct:cancelOrder").routeId("cancelOrder")
            .bean(orderService, "cancelOrder");
    }
}
