package enit.bank.repositories;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import enit.bank.domain.BankAccount;
import enit.bank.domain.enumeration.AccountStatus;
import enit.bank.exceptions.EntityNotFoundException;

@ApplicationScoped
public class BankRepository {
    @Inject
    EntityManager em;
    
    
    public BankAccount findBankAccountById(Long id) throws EntityNotFoundException{
        BankAccount bankAccount = em.find(BankAccount.class, id);
        if(bankAccount!=null){
            return bankAccount;
        }
        throw new EntityNotFoundException("cannot find bank account");
    }

    public BankAccount findBankAccountByAccountNumber (String number) throws EntityNotFoundException{
        BankAccount bankAccount = em.find(BankAccount.class, number);
        if(bankAccount!=null){
            return bankAccount;
        }
        throw new EntityNotFoundException("cannot find bank account");
    }

    public BigDecimal withdrawMoneyFromAccount(BigDecimal money, Long id){
        BankAccount bankAccount = em.find(BankAccount.class, id);
        if(bankAccount!=null){
            if (bankAccount.getAvailableBalance().compareTo(money)==1 && bankAccount.getStatus()==AccountStatus.ACTIVE){
                bankAccount.setAvailableBalance(bankAccount.getAvailableBalance().subtract(money));
                return bankAccount.getAvailableBalance();
            } 
            else return bankAccount.getAvailableBalance();
            
        }
        else return bankAccount.getAvailableBalance();
    }

}
