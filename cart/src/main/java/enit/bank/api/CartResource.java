package enit.bank.api;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import enit.bank.domain.Cart;
import enit.bank.service.CartService;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Path("/cart")
public class CartResource extends PanacheEntity {
    
    @Inject
    private CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCart(@PathParam("id") Integer id){
        return cartService.findById(id);
    }
    
    @POST
    @Path("/create")
    public Cart create(Cart p) throws EntityExistsException {
        return  CartService.create(p);
    }
    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart updateCart(@PathParam("id") Integer id, Cart cart) {
        Cart updatedCart = cartService.update(cart);
        return updatedCart;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  ResponseBuilder deleteCart(@PathParam("id") Integer id){
        cartService.delete(id);
        return Response.status(Status.OK);
    }

    
}
