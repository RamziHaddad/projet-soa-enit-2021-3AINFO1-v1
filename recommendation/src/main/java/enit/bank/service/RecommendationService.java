package enit.bank.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrServerException;

import enit.bank.Domain.Recommendation;
import enit.bank.exceptions.*;
import enit.bank.repository.RecommendationRepository;

@ApplicationScoped
public class RecommendationService {

    @Inject
    RecommendationRepository recommendationsRepo;

    public List<Recommendation> findAll() {
        return recommendationsRepo.findAll();
    }

    public Recommendation findById(UUID id) throws EntityNotFoundException {
        return recommendationsRepo.findById(id);
    }

    public Recommendation create(Recommendation r)
            throws EntityAlreadyExistsException, IOException, SolrServerException {
        return recommendationsRepo.insert(r);
    }

    public Recommendation update(Recommendation r)
            throws EntityNotFoundException, EntityAlreadyExistsException, IOException, SolrServerException {
        return recommendationsRepo.update(r);
    }

    public void remove(UUID id) {
        recommendationsRepo.delete(id);
    }

}
