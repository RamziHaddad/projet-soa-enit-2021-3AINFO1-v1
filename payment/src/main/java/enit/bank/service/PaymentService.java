package enit.bank.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import enit.bank.domain.Payment;
import enit.bank.exceptions.EntityAlreadyExistsException;
import enit.bank.repository.PaymentRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class PaymentService {
    @Inject
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayments(){
        List<Payment> paymentList= this.paymentRepository.findAllPayments();
        return paymentList;
    }

    public Payment getPaymentById(Long id)throws EntityNotFoundException{
        Payment payment =this.paymentRepository.findPaymentById(id);
        return payment;
    }

    public Payment addPayment (Payment payment)throws EntityAlreadyExistsException{
        Payment paymentAdded = paymentRepository.addPayment(payment);
        return paymentAdded;
    }
}
