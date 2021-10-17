package enit.bank.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Order;

@ApplicationScoped
public class OrdersRepository {

    @Inject
    EntityManager em;
    
    public Order insert() {
        return null;
    }

    public Order findById(Long id) {
        return null;
    }

    
    
}
