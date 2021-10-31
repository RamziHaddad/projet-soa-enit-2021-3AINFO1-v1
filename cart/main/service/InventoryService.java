package enit.cart.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@RegisterRestClient(baseUri = "http://localhost:8083/inventory")
public interface InventoryService {
    @GET
    @Path("/{itemId}")
    Integer getQuantity(@PathParam("itemId") String itemId);
}