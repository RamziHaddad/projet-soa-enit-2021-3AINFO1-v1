package enit.bank.domain;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity

@Table(name="ProductDB")

public class Product {

    private Integer id;
    private String title;
    private Long price;

    public Product(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    } 
    
}   

