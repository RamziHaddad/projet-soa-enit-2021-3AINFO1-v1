package enit.bank.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import enit.bank.domain.Orders;
import enit.bank.service.OrdersService;



@Path("/Orders")
public class OrdersResource {

   
    private OrdersService ordersService;
    public OrdersResource(OrdersService service) {
        this.ordersService = service;
    }

    @POST
    @Path("/create")
    public Orders createOrder(Orders order) {
        return ordersService.create(order);
    }

    @GET
    @Path("/{id}")
    public Orders findOrderById(@PathParam("id") Long id) {
        return ordersService.findById(id);
    }

}