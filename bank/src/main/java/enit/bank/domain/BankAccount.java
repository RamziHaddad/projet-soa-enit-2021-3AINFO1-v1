package enit.bank.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enit.bank.domain.enumeration.AccountStatus;
import enit.bank.domain.enumeration.AccountType;



@Entity
@Table(name = "banking_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private BigDecimal availableBalance;

    public BankAccount(Long id, String number, AccountType type, AccountStatus status, BigDecimal availableBalance) {
        this.id = id;
        this.accountNumber = number;
        this.accountType = type;
        this.accountStatus = status;
        this.availableBalance = availableBalance;
    }

    public BankAccount() {
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
