package enit.cart.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@RegisterRestClient(baseUri = "http://localhost:8086/pricing")
public interface PricingService {
    @GET
    @Path("/{itemId}")
    float getUnitPrice(@PathParam("itemId") String itemId);
}