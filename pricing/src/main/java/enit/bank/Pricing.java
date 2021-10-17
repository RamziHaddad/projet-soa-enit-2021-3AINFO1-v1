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
    
    
    @PUT
    @Path("pricing/promo/{id}/{percentage}")
    public Response updateProductPromo(@PathParam("id") Integer id, @PathParam("percentage") float percentage) {

        getCollection().updateOne(Filters.eq("id", id), Updates.set("promoValue", percentage));
        return Response.ok().entity("product promo changed").build();

    }

    @POST
    @Path("pricing/desactivate-promo/{id}")
    public Response desactivateProductPromo(@PathParam("id") Integer id) {
        getCollection().updateOne(Filters.eq("id", id), Updates.set("promo", false));
        return Response.ok().entity("product promo desactivated").build();
    }

    @POST
    @Path("pricing/activate-promo/{id}")
    public Response activateProductPromo(@PathParam("id") Integer id) {
        getCollection().updateOne(Filters.eq("id", id), Updates.set("promo", true));
        return Response.ok().entity("product promo activated").build();
    }

    @POST
    @Path("pricing/promocategorie/{promoValue}/{categorie}")
    public Response setCategoriePromo(@PathParam("categorie") String categorie,
            @PathParam("promoValue") float promoValue) {
        getCollection().updateMany(Filters.eq("categorie", categorie), Updates.set("promo", true));
        getCollection().updateMany(Filters.eq("categorie", categorie), Updates.set("promoValue", promoValue));

        return Response.ok().entity("promo categorie enabled").build();
    }


   

   

}
