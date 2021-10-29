package enit.bank.service.dto;

import java.math.BigDecimal;

import enit.bank.domain.enumeration.AccountStatus;
import enit.bank.domain.enumeration.AccountType;

public class BankAccountDTO {
    private Long id;

    private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    
    public BankAccountDTO() {
    }
    
    public BankAccountDTO(Long id, String number, AccountType type, AccountStatus status, BigDecimal availableBalance) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.status = status;
        this.availableBalance = availableBalance;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public AccountType getType() {
        return type;
    }
    public void setType(AccountType type) {
        this.type = type;
    }
    public AccountStatus getStatus() {
        return status;
    }
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }
}
