package enit.bank.api;


import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import enit.bank.domain.Payment;
import enit.bank.exceptions.EntityAlreadyExistsException;
import enit.bank.exceptions.EntityNotFoundException;
import enit.bank.service.BankService;
import enit.bank.service.PaymentService;
import enit.bank.service.dto.PaymentForAddDTO;

@Path("/api/payments")
public class PaymentRessource {
    @RestClient
    BankService bankService; 

    @Inject
    PaymentService paymentService;
   
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    
    @GET
    public Response getAllPayments() {
        return  Response.ok(this.paymentService.getAllPayments()).build();
    }

    @GET
    @Path("/{id}")
    public Response getPaymentById(@PathParam("id") Long id) throws EntityNotFoundException {
        return  Response.ok(this.paymentService.getPaymentById(id)).build();
    }

    @POST
    @Transactional
    public Response createPayment(@RequestBody PaymentForAddDTO paymentForAddDTO) throws EntityAlreadyExistsException {
       Payment paymentAdded= this.paymentService.addPayment(paymentForAddDTO);
       BigDecimal remainingAmount = this.bankService.withdrawMoneyFromAccount(money, id)
       return Response.ok(paymentAdded).build();
    }



}
