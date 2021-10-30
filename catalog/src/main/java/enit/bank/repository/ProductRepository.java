package enit.bank.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.smallrye.mutiny.Multi;

import enit.bank.domain.Product;

public class ProductRepository {

    @Inject
    EntityManager entit ;

    public Product getById (Integer id){
        Product prod=null;
        return prod;
    }

    public  Multi<Product> getProducts(){
       Multi<Product> list = null ;
       return list;
    }

    public String deleteById(Integer id){
        return "Product deleted";
    }

    public Product update(Product prod){
        return null ;
    }


}
