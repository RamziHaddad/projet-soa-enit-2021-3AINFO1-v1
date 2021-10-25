package enit.bank.service.dto;

import java.time.Instant;

public class PaymentFoaAddDTO {
    private String paymentMode;

    private String cartName;
   
    private Long cartNumber;
    private Long secretCode;
    private Instant ExpirationDate;
    
    public PaymentFoaAddDTO() {
    }

    
    public PaymentFoaAddDTO(String paymentMode, String cartName, Long cartNumber, Long secretCode,
            Instant expirationDate) {
        this.paymentMode = paymentMode;
        this.cartName = cartName;
        this.cartNumber = cartNumber;
        this.secretCode = secretCode;
        ExpirationDate = expirationDate;
    }


    public String getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    public String getCartName() {
        return cartName;
    }
    public void setCartName(String cartName) {
        this.cartName = cartName;
    }
    public Long getCartNumber() {
        return cartNumber;
    }
    public void setCartNumber(Long cartNumber) {
        this.cartNumber = cartNumber;
    }
    public Long getSecretCode() {
        return secretCode;
    }
    public void setSecretCode(Long secretCode) {
        this.secretCode = secretCode;
    }
    public Instant getExpirationDate() {
        return ExpirationDate;
    }
    public void setExpirationDate(Instant expirationDate) {
        ExpirationDate = expirationDate;
    }
    
}
