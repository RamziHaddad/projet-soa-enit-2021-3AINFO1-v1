package enit.bank.service;

import javax.persistence.criteria.Order;
import enit.bank.repository.OrdersRepository;
public class OrdersService {

    OrdersRepository ordersRepository;
    public OrdersService( OrdersRepository ordersRepository){
        this.ordersRepository=ordersRepository;
    }

    public Orders create(Orders orders) {
        //verifier le reste des fonctions
        return ordersRepository.insert(orders);
    }

    public Orders findById(Long id) {
        return null;
    }

    
}