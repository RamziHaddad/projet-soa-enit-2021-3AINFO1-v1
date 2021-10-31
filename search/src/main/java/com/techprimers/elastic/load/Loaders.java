package com.techprimers.elastic.load;

import com.techprimers.elastic.model.Product;
import com.techprimers.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    ProductRepository productsRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Product.class);
        System.out.println("Loading Data");
        productsRepository.save(getData());
        System.out.printf("Loading Completed");

    }

    private List<Product> getData() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("gel nettoyant",123L, "Avec l’aloe Vera et l’huile d’argan, ce gel nettoyant visage nettoie en douceur et désobstrue les pores en profondeur. La peau est nette, fraiche et purifiée." +
          "Appliquez sur une peau mouillée et faire mousser pour un nettoyage optimal, rincez abondamment", 12000L, "Soins pour le visage"));
        products.add(new Product("après rasage",16900L, "Apaisant + Hydratant 24H + Défatigant"+
          "Ce soin Après-rasage hypoallergénique avec une formule hautement concentrée et riche en Aloe Vera et en huile d’argan, pénètre facilement, laissant la peau tonifiée, hydratée et extrêmement douce et apaisée. Faites de l’instant rasage un moment de plaisir grâce à cet après-rasage sans alcool ! Appliquez après le rasage.", 22000L, "Soins pour le visage"));
        products.add(new Product("ecran spf 50+",13500L, "Jamais un écran n’a été aussi Riche" +
          "Cet Ecran d’Arvea Nature a un indice de protection solaire +50." +
          "La crème est concentrée et n’est pas huileuse, elle est Waterproof, elle pénètre très rapidement, et surtout ne laisse pas la peau grasse." +
          "Ne laisse pas de résidus ou de sensation collante sur la peau.", 35800L, "Soins pour le visage"));
        return products;
    }
}
