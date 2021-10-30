package enit.bank.repository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import enit.bank.Domain.*;
import enit.bank.exceptions.EntityAlreadyExistsException;
import enit.bank.exceptions.EntityNotFoundException;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.*;
import java.util.*;





@ApplicationScoped
public class RecommendationRepository {
    @Inject
    EntityManager em;
    String urlString = "http://localhost:8983/solr/recommendation";
    HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    //solr.setParser(new XMLResponseParser());
    public List<Recommendation> findAll(){
        return em.createQuery("from Recommendations",Recommendation.class).getResultList();
    }

    // found recommendation of a product
    public List<Recommendation> findByIdProd(String productId) throws EntityNotFoundException, SolrServerException, IOException {
        SolrQuery query = new SolrQuery();
        query.setQuery("productId1:"+productId +" OR productId2:"+productId);

         QueryResponse response = solr.query(query);

         SolrDocumentList docList = response.getResults();
         assertEquals(docList.getNumFound(), 1);
         DocumentObjectBinder binder = new DocumentObjectBinder();
        List<Recommendation> dataList = binder.getBeans(Recommendation.class, docList);


        if(dataList!=null){
            return dataList;
        }
        throw new EntityNotFoundException("cannot find recommendation");
    }
    // found recommendation of two products
    public List<Recommendation> findByIdTwoProd(String productId1,String productId2) throws EntityNotFoundException, SolrServerException, IOException{
        SolrQuery query = new SolrQuery();
        query.setQuery("(productId1:"+productId1 +" AND productId2:"+productId2+") OR (productId1:"+productId2 +" AND productId2:"+productId1+")");

         QueryResponse response = solr.query(query);

         SolrDocumentList docList = response.getResults();
         assertEquals(docList.getNumFound(), 1);
         DocumentObjectBinder binder = new DocumentObjectBinder();
        List<Recommendation> dataList = binder.getBeans(Recommendation.class, docList);


        if(dataList!=null){
            return dataList;
        }
        throw new EntityNotFoundException("cannot find Recommendation");
    }
    public Recommendation findById(UUID id) throws EntityNotFoundException{
        Recommendation r = em.find(Recommendation.class, id);
        if(r!=null){
            return r;
        }
        throw new EntityNotFoundException("cannot find Recommendation");
    }
    @Transactional
    public Recommendation insert(Recommendation r) throws EntityAlreadyExistsException, IOException, SolrServerException{
        solr.setParser(new XMLResponseParser());
        if(r.getId() == null){
            r.setId(UUID.randomUUID());
            try{
                solr.addBean(r);
                solr.commit();
                em.persist(r);
                return r;
            }catch(EntityExistsException e){
                throw new EntityAlreadyExistsException("Recommendation already exists");
            }
        }
        throw new EntityAlreadyExistsException("Recommendation has already an id");
    }
    @Transactional
    public Recommendation update(Recommendation r) throws EntityNotFoundException{
        try{
            return em.merge(r);
        }catch(IllegalArgumentException e){

        }
        throw new EntityNotFoundException("cannot find person");
    }

    @Transactional
    public void delete(UUID id){
        Recommendation r = em.find(Recommendation.class, id);
        if(r!=null){
            em.remove(r);
        }

    }
    
}
