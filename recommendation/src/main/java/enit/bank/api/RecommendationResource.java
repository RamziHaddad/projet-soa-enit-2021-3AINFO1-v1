package enit.bank.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.solr.client.solrj.SolrServerException;

import enit.bank.Domain.Recommendation;
import enit.bank.exceptions.EntityAlreadyExistsException;
import enit.bank.exceptions.EntityNotFoundException;
import enit.bank.service.RecommendationService;
import enit.bank.Algo.Algorithme;

import java.io.IOException;
import java.util.*;

@Path("/api/recommendations")
public class RecommendationResource {

    @Inject
    RecommendationService recommendationService;

    @POST
    public void create(List<String> listIdProduct)
            throws EntityNotFoundException, EntityAlreadyExistsException, IOException, SolrServerException {
                if(listIdProduct.size()!=1){
                    List<Recommendation> recommendations = Algorithme.algo(listIdProduct, recommendationService.findAll());
                    for (var i = 0; i < recommendations.size(); i++) {
                        // System.out.println(recommendations.get(i).toString());
                        if (recommendations.get(i).getNbrOccurrences() == 1) {
                            recommendationService.create(recommendations.get(i));
                        } else {
                            recommendationService.update(recommendations.get(i));
                        }
                    }
                }

    }

    @GET
    @Path("/{idProduct}")
    public List<Recommendation> findById(@PathParam("idProduct") String id) throws EntityNotFoundException, SolrServerException, IOException {

        return recommendationService.findByIdProd(id);
    }

}
