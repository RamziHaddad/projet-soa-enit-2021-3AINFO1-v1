import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;


@Path("/cart")
public class CartResource {
    
    @Inject
    private static CartRepository cartRepository;

    @POST
    @Path("/create")
    public Cart createCart(){
        return cartRepository.create() ;
    }
    
    @GET
    @Path("find/{id}")
    public static Cart getCart(@PathParam("id") String id){
        return cartRepository.findById(id);
    }
    
    @DELETE
    @Path("/delete/{id}")
    public  ResponseBuilder deleteCart(@PathParam("id") Integer id){
        cartRepository.deleteCart(id);
        return Response.status(Status.OK);
    }
 
}