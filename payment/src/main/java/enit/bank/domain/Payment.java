package enit.bank.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal amount;
    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "cart_name")
    private String cartName;
    
    @Column(name = "cart_number")
    private Long cartNumber;
    
    @Column(name = "secret_code")
    private Long secretCode;
    
    @Column(name = "expiration_date")
    private Instant expirationDate;

    @Column (name ="from_account_number")
    private String fromAccountNumber;
    
    public Payment() {
    }


    public Payment(Long id, BigDecimal amount, String paymentMode, String cartName, Long cartNumber, Long secretCode,
            Instant expirationDate, String fromAccountNumber) {
        this.id = id;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.cartName = cartName;
        this.cartNumber = cartNumber;
        this.secretCode = secretCode;
        this.expirationDate = expirationDate;
        this.fromAccountNumber = fromAccountNumber;
    }







    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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


    public BigDecimal getAmount() {
        return amount;
    }



    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
        return expirationDate;
    }


    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }
    

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }


    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
        result = prime * result + ((cartName == null) ? 0 : cartName.hashCode());
        result = prime * result + ((cartNumber == null) ? 0 : cartNumber.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((paymentMode == null) ? 0 : paymentMode.hashCode());
        result = prime * result + ((secretCode == null) ? 0 : secretCode.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Payment other = (Payment) obj;
        if (expirationDate == null) {
            if (other.expirationDate != null)
                return false;
        } else if (!expirationDate.equals(other.expirationDate))
            return false;
        if (cartName == null) {
            if (other.cartName != null)
                return false;
        } else if (!cartName.equals(other.cartName))
            return false;
        if (cartNumber == null) {
            if (other.cartNumber != null)
                return false;
        } else if (!cartNumber.equals(other.cartNumber))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (paymentMode == null) {
            if (other.paymentMode != null)
                return false;
        } else if (!paymentMode.equals(other.paymentMode))
            return false;
        if (secretCode == null) {
            if (other.secretCode != null)
                return false;
        } else if (!secretCode.equals(other.secretCode))
            return false;
        return true;
    }


    


    
}
