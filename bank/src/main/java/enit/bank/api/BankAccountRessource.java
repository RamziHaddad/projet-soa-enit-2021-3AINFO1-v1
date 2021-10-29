package enit.bank.api;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

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
    @Path("/{number}")
    public Response getAccountByNumber(@PathParam("number") String number) throws EntityNotFoundException {
        return Response.ok(bankService.getBankAccountByAccountNumber(number)).build();
    }

    @GET
    @Path("/{id}")
    public Response withdrawMoneyFromAccount(@RequestBody BigDecimal money, @PathParam("id") Long id){
        return Response.ok(this.bankService.withdrawMoneyFromAccount(money, id)).build();
    }
}
