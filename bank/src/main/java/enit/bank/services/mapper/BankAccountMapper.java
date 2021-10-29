package enit.bank.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import enit.bank.domain.BankAccount;
import enit.bank.services.dto.BankAccountDTO;

@Mapper(componentModel = "cdi")
public interface BankAccountMapper {
    BankAccountMapper instance = Mappers.getMapper(BankAccountMapper.class);
    BankAccountDTO BankAccountToBankAccountDTO (BankAccount bankAccount);
    
}
