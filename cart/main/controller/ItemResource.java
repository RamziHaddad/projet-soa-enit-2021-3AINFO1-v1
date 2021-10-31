package enit.cart.controller;

import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import enit.cart.domain.Item;
import enit.cart.domain.Cart;
import enit.cart.exception.ItemNotFoundException;
import enit.cart.repository.CartRepository;
import enit.cart.repository.ItemRepository;
import enit.cart.service.InventoryService;
import enit.cart.service.PricingService;


@Path("/cart/items")
public class ItemResource {
    
    @RestClient 
    @Inject
    InventoryService inventoryService;

    @RestClient
    @Inject
    PricingService pricingService;
    
    @Inject
    ItemRepository itemRepository;
    @Inject
    CartRepository cartRepository;

    @GET
    @Path("/find/{id}")
    public Item getItem(@PathParam("id") String id){
        return itemRepository.findById(id);
    }

    @GET
    @Path("/find/cart/{id}")
    public List<Item> getItems(@PathParam("id") String id){
        return CartResource.getCart(id).cartContent();
    }

    @POST
    @Path("/addItems/{id}")
    public Item addToCart(@PathParam("id") String id, String itemId, Integer q){
       if (q < inventoryService.getQuantity(itemId))
       {
          Item newItem = new Item(itemId, q, pricingService.getUnitPrice(itemId)); 
          return newItem;
       }
       else return null; 
    }

    @DELETE
    @Path("/deleteItem/{cartId}/{itemId}")
    public void removeItem(@PathParam("itemId") String itemId, @PathParam("cartId") String cartId) throws ItemNotFoundException{
        Item item = itemRepository.findById(itemId);
        Cart cart = CartResource.getCart(cartId);
        //supprimer item envoyé de la liste
        itemRepository.delete(item, cart.cartContent());
    }
    
    @PATCH
    @Path("/updateItem/{cartId}/{itemId}")
    public void updateItemQuantity(@PathParam("cartId") String cartId, @PathParam("itemId") String itemId) {
        Item item = itemRepository.findById(itemId);
        Cart cart = CartResource.getCart(cartId);
        itemRepository.update(item, cart.cartContent());

    }
}
