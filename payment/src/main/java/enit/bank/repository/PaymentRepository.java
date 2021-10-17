package enit.bank.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import enit.bank.domain.Payment;
import enit.bank.exceptions.EntityAlreadyExistsException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PaymentRepository implements PanacheRepository<Payment> {
  /*  @Inject
    EntityManager em;
    public List<Payment> findAllPayments(){
        return em.createQuery("from Payments",Payment.class).getResultList();
    }
    public Payment findPaymentById(Long id) throws EntityNotFoundException{
        Payment payment = em.find(Payment.class, id);
        if(payment!=null){
            return payment;
        }
        throw new EntityNotFoundException("cannot find payment");
    }
    @Transactional
    public Payment addPayment(Payment paymentForAdd) throws EntityAlreadyExistsException{
        if(paymentForAdd.getId() == null){
            try{
                em.persist(paymentForAdd);
                return paymentForAdd;
            }catch(EntityExistsException e){
                throw new EntityAlreadyExistsException("payment already exists");
            }
        }
        throw new EntityAlreadyExistsException("person has already an id");
    }
    @Transactional
    public Payment updatePayment(Payment paymentForAdd) throws EntityNotFoundException{
        try{
            return em.merge(paymentForAdd);
        }catch(IllegalArgumentException e){

        }
        throw new EntityNotFoundException("cannot find Payment");
    }

    @Transactional
    public void deletePayment(Long id){
        Payment payment = em.find(Payment.class, id);
        if(payment!=null){
            em.remove(payment);
        }
    }*/

    
}
