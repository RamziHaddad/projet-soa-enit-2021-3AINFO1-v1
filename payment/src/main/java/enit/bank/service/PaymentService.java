package enit.bank.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import enit.bank.domain.Payment;
import enit.bank.repository.PaymentRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class PaymentService {
    @Inject
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayments(){
        PanacheQuery<Payment> paymentList= this.paymentRepository.findAll();
        
        if (!paymentList.equals(null)){
            List<Payment> list =paymentList.list();
            return list;
        }
        else return null;
    }

    public Payment getPaymentById(Long id)throws EntityNotFoundException{
        Payment payment =this.paymentRepository.findById(id);
        return payment;
    }
}
