package enit.bank.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import enit.bank.domain.Cart;
import enit.bank.service.CartService;

@ApplicationScoped
public class CartRepository {

    @Inject
    EntityManager em;

    public Cart insert(Cart cart) {
        return null;
    }

    public Cart findById(Integer id) {
        Cart c=null;
        return c;
    }

    public Cart update(Cart cart) {
        return null;
    }

    public String deleteById(Integer id) {
        return "Cart deleted";
    }
    
}
