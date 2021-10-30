package enit.bank.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import io.smallrye.mutiny.Multi;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import enit.bank.service.*;
import enit.bank.domain.*;


@Path("/product")
public class ProductResource {

    @Inject
    private ProductService prodService;

    public ProductResource(ProductService prodService){
        this.prodService= prodService;
    }
    
    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Product> getProds() {
        return prodService.getProds();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProd(@PathParam("id") Integer id) {
        return prodService.getById(id);
    }

    @PATCH
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProd (@PathParam("id") Integer id, Product prod) {
        Product updateProd = prodService.update(prod);
        return updateProd ;
    }   

    @DELETE
    @Path("/delet/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBuilder deleteProduct(@PathParam("id") Integer id) {
        prodService.deleteProduct(id);
        return Response.status(Status.OK);
    }

}