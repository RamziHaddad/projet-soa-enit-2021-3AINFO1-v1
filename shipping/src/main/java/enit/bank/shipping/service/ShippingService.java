package enit.bank.shipping.service;

import enit.bank.shipping.domain.Shipping;


public interface ShippingService {

    void createShippingRequest(Long orderId);

    void acknowledgeDelivery(Long shippingId);
}
