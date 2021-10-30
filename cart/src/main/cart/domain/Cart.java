package enit.cart.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Cart {
    
    private String id;
    private List<Item> items = new ArrayList<>();

    public Cart() {
    }

    public List<Item> cartContent() {
        return items;
    }

    public Cart add(Item item) {
        items.add(item);
        return this;
    }

    public Cart remove(Item item) {
        items.remove(item);
        return this;
    }

    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", items=" + items +
                '}';
    }

} 