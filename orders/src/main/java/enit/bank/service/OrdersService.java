package enit.bank.service;

import javax.persistence.criteria.Order;
import enit.bank.repository.OrdersRepository;
public class OrdersService {

    OrdersRepository ordersRepository;
    public OrdersService( OrdersRepository ordersRepository){
        this.ordersRepository=ordersRepository;
    }

    public Order create(Order order) {
        //verifier le reste des fonctions
        return ordersRepository.insert();
    }

    public Order findById(Long id) {
        return null;
    }

    
}