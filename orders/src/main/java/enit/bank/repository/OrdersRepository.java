package enit.bank.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Order;

@ApplicationScoped
public class OrdersRepository {

    @Inject
    EntityManager em;
    
    public Orders insert() {
        return null;
    }

    public Orders findById(Long id) {
        return null;
    }

    
    
}
