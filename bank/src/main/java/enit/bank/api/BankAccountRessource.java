package enit.bank.api;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import enit.bank.exceptions.EntityNotFoundException;
import enit.bank.services.BankService;

@Path("/api/bank")
public class BankAccountRessource {
    @Inject
    BankService bankService;

   
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    
    @GET
    public Response getAccountByNumber(String number) throws EntityNotFoundException {
        return Response.ok(bankService.getBankAccountByAccountNumber(number)).build();
    }

    @GET
    public Response withdrawMoneyFromAccount(BigDecimal money, Long id){
        return Response.ok(this.bankService.withdrawMoneyFromAccount(money, id)).build();
    }
}
