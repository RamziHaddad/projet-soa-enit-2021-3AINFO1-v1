package enit.bank.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import enit.bank.domain.Payment;
import enit.bank.exceptions.EntityAlreadyExistsException;
import enit.bank.repository.PaymentRepository;
import enit.bank.service.dto.PaymentDTO;
import enit.bank.service.dto.PaymentForAddDTO;
import enit.bank.service.mapper.PaymentMapper;

@ApplicationScoped
public class PaymentService {
    @Inject
    PaymentRepository paymentRepository;

    public List<PaymentDTO> getAllPayments(){
        List<Payment> paymentList= this.paymentRepository.findAllPayments();
        List<PaymentDTO> paymentDTOs= new ArrayList<>();
        for (Payment payment:paymentList){
            paymentDTOs.add(PaymentMapper.instance.PaymentToPaymentDTO(payment));
        }
        return paymentDTOs;
    }

    public PaymentDTO getPaymentById(Long id) throws EntityNotFoundException{
        Payment payment =this.paymentRepository.findPaymentById(id);
        return PaymentMapper.instance.PaymentToPaymentDTO(payment);
    }

    public Payment addPayment (PaymentForAddDTO paymentForAddDTO)throws EntityAlreadyExistsException{
        Payment payment=PaymentMapper.instance.PaymentForAddDTOToPayment(paymentForAddDTO);
        Payment paymentAdded = paymentRepository.addPayment(payment);
        return paymentAdded;
    }
}
