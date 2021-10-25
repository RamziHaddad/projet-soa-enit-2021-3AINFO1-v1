package enit.bank.api;

import java.util.List;

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

import enit.bank.domain.Payment;
import enit.bank.exceptions.EntityAlreadyExistsException;
import enit.bank.exceptions.EntityNotFoundException;
import enit.bank.service.PaymentService;

@Path("/api/payments")
public class PaymentRessource {
    
    @Inject
    PaymentService paymentService;
   
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    
    @GET
    public List<Payment> getAllPayments() {
        return  paymentService.getAllPayments();
    }

    @GET
    @Path("/{id}")
    public Payment getPaymentById(@PathParam("id") Long id) throws EntityNotFoundException {
        return  paymentService.getPaymentById(id);
    }

    @POST
    @Transactional
    public Payment createPayment(Payment payment) throws EntityAlreadyExistsException {
       return this.paymentService.addPayment(payment);
    }



}
