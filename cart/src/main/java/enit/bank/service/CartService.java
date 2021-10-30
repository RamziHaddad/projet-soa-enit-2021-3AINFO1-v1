package enit.bank.service;

import javax.inject.Inject;

import enit.bank.domain.Cart;
import enit.bank.repository.CartRepository;
import enit.bank.exceptions.*;

public class CartService {

    @Inject
    CartRepository cartRepository;
    public CartService(CartRepository cartRepo){
        this.cartRepository = cartRepo;
     } 

     public Cart create(Cart p) throws CartAlreadyExistsException{
        return cartRepository.insert(p);
    }

    public Object addToCart(Cart cart) {
        return cartRepository.insert(cart);
    }

    public Cart findById(Integer id){
        return cartRepository.findById(id);
    }

    public Cart update(Cart cart){
        return cartRepository.update(cart);
    }

    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }


    
}
