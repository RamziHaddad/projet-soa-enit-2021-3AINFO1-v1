package enit.bank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import io.quarkus.vertx.http.runtime.devmode.Json;
import io.vertx.core.json.JsonObject;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.Consumes;
import javax.inject.Inject;
import static com.mongodb.client.model.Projections.*;

@Path("/api/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Pricing {
    @Inject
    MongoClient mongoClient;

    // get mongo collection
    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("enit").getCollection("product");
    }

    @POST
    @Path("/pricing/{productId}/{price}")
    public Response setPrice(@PathParam("productId") Integer id, @PathParam("price") float price) {

        getCollection().updateOne(Filters.eq("id", id), Updates.set("price", price));
        return Response.ok().entity("product price changed").build();

    }
     // manque d'informations !!!

    // @GET
    // @Path("pricing/cart/{id}")
    // public float getPriceCart(@PathParam("id") Integer id) {

    // }

   

   

}