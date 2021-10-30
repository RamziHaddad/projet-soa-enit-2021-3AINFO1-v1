package enit.bank.service;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import enit.bank.service.dto.BankAccountDTO;

@RegisterRestClient(baseUri = "http://localhost:8091/bank")
public interface BankService {
    @GET
    @Path("/{id}")
    BigDecimal withdrawMoneyFromAccount(BigDecimal money, Long id);
    BankAccountDTO getBankAccountByAccountNumber(String number);
}
