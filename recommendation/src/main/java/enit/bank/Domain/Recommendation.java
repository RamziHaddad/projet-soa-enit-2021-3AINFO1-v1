package enit.bank.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.solr.client.solrj.beans.Field;

import java.util.*;

@Entity
@Table(name = "Recommendations")
public class Recommendation {
    @Id
    private UUID id;
    String productId1;
    String productId2;
    int nbrOccurrences;

    @Field("id")
    public void setId(UUID id) {
        this.id = id;
    }

    @Field("setProductId1")
    public void setProductId1(String productId1) {
        this.productId1 = productId1;
    }

    @Field("setProductId2")
    public void setProductId2(String productId2) {
        this.productId2 = productId2;
    }

    @Field("setNbrOccurrences")
    public void setNbrOccurrences(int nbrOccurrences) {
        this.nbrOccurrences += nbrOccurrences;
    }

    public Recommendation() {
    }

    public Recommendation(String productId1, String productId2) {
        super();
        this.productId1 = productId1;
        this.productId2 = productId2;
        this.nbrOccurrences = 1;
        ;
    }

    public Recommendation(String productId1, String productId2, int nbrOccurrences) {
        super();
        this.productId1 = productId1;
        this.productId2 = productId2;
        this.nbrOccurrences = nbrOccurrences;
        ;
    }

    public int getNbrOccurrences() {
        return nbrOccurrences;
    }

    public boolean compareTo(Recommendation r) {

        return (this.productId1 == r.productId1 && this.productId2 == r.productId2)
                || (this.productId1 == r.productId2 && this.productId2 == r.productId1);
    }

    public String getProductId1() {
        return productId1;
    }

    public String getProductId2() {
        return productId2;
    }

    @Override
    public String toString() {
        return this.productId1 + "," + this.productId2 + "," + this.nbrOccurrences;
    }

    public UUID getId() {
        return id;
    }

}
