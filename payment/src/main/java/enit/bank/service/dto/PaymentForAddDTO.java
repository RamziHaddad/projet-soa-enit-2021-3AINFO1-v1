package enit.bank.service.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentForAddDTO {
    private String paymentMode;
    private BigDecimal amount;
    private String cartName;
    private String fromAccountNumber;
    private Long cartNumber;
    private Long secretCode;
    private Instant ExpirationDate;
    
    public PaymentForAddDTO() {
    }

    
    public PaymentForAddDTO(String paymentMode, String cartName, Long cartNumber, Long secretCode,
            Instant expirationDate,BigDecimal amount, String fromAccountNumber) {
        this.paymentMode = paymentMode;
        this.cartName = cartName;
        this.cartNumber = cartNumber;
        this.secretCode = secretCode;
        ExpirationDate = expirationDate;
        this.amount=amount;
        this.fromAccountNumber=fromAccountNumber;
    }


    public String getFromAccountNumber() {
        return fromAccountNumber;
    }


    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
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


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    
}
