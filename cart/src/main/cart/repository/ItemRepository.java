package enit.cart.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import enit.cart.domain.Item;

public class ItemRepository {
   
    @Inject
    EntityManager em;

    public Item findById(String id) {
       Item i = em.find(Item.class, id);
       if(i!=null){
        return i;
    }
    throw new EntityNotFoundException("cannot find person");
    }
    
    public void delete(Item item, List<Item> cartContent) {
        cartContent.remove(item);
    }

    public void update(Item item, List<Item> cartContent) {
        Integer index  = cartContent.indexOf(item);
        Item item1 = cartContent.get(index);
        //if item.quantity is a negative value => remove from the original quantity
        //else add
        item1.setQuantity(item.getQuantity()+ item1.getQuantity());
    }
     
}
