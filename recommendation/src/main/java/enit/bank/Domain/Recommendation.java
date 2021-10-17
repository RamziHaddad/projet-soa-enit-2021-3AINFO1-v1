package enit.bank.Domain;

public class Recommendation {
    String productId1;
    String productId2;
    int nbrOccurrences;

    public Recommendation(String productId1, String productId2) {
        super();
        this.productId1 = productId1;
        this.productId2 = productId2;
        this.nbrOccurrences = 1;
        ;
    }
}
