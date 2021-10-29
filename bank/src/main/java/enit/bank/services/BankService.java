package enit.bank.services;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import enit.bank.domain.BankAccount;
import enit.bank.exceptions.EntityNotFoundException;
import enit.bank.repositories.BankRepository;
import enit.bank.services.dto.BankAccountDTO;
import enit.bank.services.mapper.BankAccountMapper;

@ApplicationScoped
public class BankService {
    @Inject
    BankRepository bankRepository;


    public BankAccountDTO getBankAccountById(Long id) throws EntityNotFoundException{
        BankAccount bankAccount =this.bankRepository.findBankAccountById(id);
        return BankAccountMapper.instance.BankAccountToBankAccountDTO(bankAccount);
    }

    public BankAccountDTO getBankAccountByAccountNumber(String number) throws EntityNotFoundException{
        BankAccount bankAccount =this.bankRepository.findBankAccountByAccountNumber(number);
        return BankAccountMapper.instance.BankAccountToBankAccountDTO(bankAccount);
    }
    
    public BigDecimal withdrawMoneyFromAccount(BigDecimal money, Long id){
        return this.bankRepository.withdrawMoneyFromAccount(money, id);
    }
}
