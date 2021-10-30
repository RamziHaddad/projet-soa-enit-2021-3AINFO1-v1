package enit.bank.domain;

import java.math.BigDecimal;

public class OrderItem {
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal productPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getPrice() {
        return productPrice.multiply(new BigDecimal(quantity));
    }
    
}
