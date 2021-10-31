package enit.bank.shipping.rest;


public interface ShippingRestService {

    void createShipping(Long orderId);

    void acknowledgeDelivery(Long shippingId);
}
