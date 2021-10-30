package enit.bank.services.dto;

import java.math.BigDecimal;

import enit.bank.domain.enumeration.AccountStatus;
import enit.bank.domain.enumeration.AccountType;

public class BankAccountDTO {
    private Long id;

    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private BigDecimal availableBalance;
    
    public BankAccountDTO() {
    }
    
    public BankAccountDTO(Long id, String number, AccountType type, AccountStatus status, BigDecimal availableBalance) {
        this.id = id;
        this.accountNumber = number;
        this.accountType = type;
        this.accountStatus = status;
        this.availableBalance = availableBalance;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return accountNumber;
    }
    public void setNumber(String number) {
        this.accountNumber = number;
    }
    public AccountType getType() {
        return accountType;
    }
    public void setType(AccountType type) {
        this.accountType = type;
    }
    public AccountStatus getStatus() {
        return accountStatus;
    }
    public void setStatus(AccountStatus status) {
        this.accountStatus = status;
    }
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

}
